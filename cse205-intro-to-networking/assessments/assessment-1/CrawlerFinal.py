import socket
import re
import os
import ssl

# HTTP(S) = port 80 (443)
PORT = 80


class CrawlerFinal:

    def __init__(self, name):
        # sets for storing images and hyperlinks
        self.image_path_set = set()
        self.hyperlink_set = set()
        self.name = name

    def get_name(self):
        return self.name

    def create_dir(self, p_host, p_uri):
        # Returns a string representing the current working directory
        cwd = os.getcwd()

        fullname = os.path.join(cwd, p_host + "/" + p_uri + "/")
        path, basename = os.path.split(fullname)
        if not os.path.exists(path):
            print("Creating directory: " + path)
            os.makedirs(path)

    def request_data(self, p_host, p_req):
        # Connect to a remote socket at address.
        byte_data = b''
        sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        sock.settimeout(20.0)
        sock.connect((p_host, PORT))
        sock.sendall(p_req.encode())
        try:
            result = sock.recv(4096)
            byte_data += result
        except OSError as e:
            # TIMED OUT
            print(e)
            return
        while len(result) > 0:
            try:
                result = sock.recv(4096)
                byte_data += result
            except OSError as e:
                print("TIMED OUT")
                print(e)
                break
        # SOCK.close()
        return byte_data

    def extract_http_header_data(self, byte_data):
        eoh = byte_data.find(b'\r\n\r\n')
        header = byte_data[:eoh + 4]
        return header

    def extract_http_body_data(self, byte_data):
        eoh = byte_data.find(b'\r\n\r\n')
        body = byte_data[eoh + 4:]
        return body

    def extract_hyperlinks(self, doc_byte_data, host, uri):
        re_sults = re.findall(r'href\s?=\s?"(.*?)"', doc_byte_data.decode())
        re_sults_filter = ["javascript", ".rss", ".css", ".jpg", ".jpeg", ".png", ".gif", ".webp", ".svg"]
        for hyperlink in re_sults:
            # Check if link is not original page and not current page
            re_link_proto = re.findall(r'https?://', hyperlink)

            # Did not find https?:// in hyperlink
            curr_pg = host + uri
            if not re_link_proto:
                # Check if link is same as current page host + uri
                if hyperlink is not curr_pg:
                    if not any(link in hyperlink for link in re_sults_filter):
                        # this is for handling relative links
                        if "http" not in hyperlink:
                            hyperlink = host + '/' + hyperlink
                        self.hyperlink_set.add(hyperlink)
            else:
                # Found http protocol in link, check if link is same as curr_pg
                if hyperlink is not re_link_proto[0] + curr_pg:
                    if not any(link in hyperlink for link in re_sults_filter):
                        # this is for handling relative links
                        if "http" not in hyperlink:
                            hyperlink = host + '/' + hyperlink
                        self.hyperlink_set.add(hyperlink)
        print('-' * 20)
        print("Found " + str(len(self.hyperlink_set)) + " page links")
        print('-' * 20)

    def extract_image_paths(self, doc_byte_data):
        re_sults = re.findall(
            r'([^="]+?\.(jpg\.?j?p?g?|jpeg\.?j?p?e?g?|png\.?p?n?g?|gif\.g?i?f?|webp\.w?e?b?p?|svg\.s?v?g?))',
            doc_byte_data.decode())
        re_sults_filter = ["http", ";", "<", ">", "{", "}"]

        for image_path in re_sults:
            if not any(i in image_path[0] for i in re_sults_filter):
                self.image_path_set.add(image_path[0])
        print('-' * 20)
        print("Found " + str(len(self.image_path_set)) + " images")
        print('-' * 20)

    def get_image_name(self, p_image_path):
        if "/" not in p_image_path:
            # Add full image path (=image name) to list
            image_name = p_image_path
        # Else use regex to search for name pattern in path
        else:
            image_name = re.findall(r'.*\/(.*)', p_image_path)
        return image_name

    def request_and_save_images(self, p_host, p_uri_loc):
        image_count = 0
        for image in self.image_path_set:
            img_name = self.get_image_name(image)[0]
            file = p_host + p_uri_loc + img_name
            if not os.path.isfile(file):
                if image[0] == '/':
                    image_request = "GET " + image + " HTTP/1.1\r\nHost: " + p_host + "\r\nConnection:close\r\n\r\n"
                else:
                    image_request = "GET " + p_uri_loc + image + " HTTP/1.1\r\nHost: " + p_host + "\r\nConnection:close\r\n\r\n"

                print("Downloading image: " + image)
                image_data = self.request_data(p_host, image_request)
                self.create_file(p_host, p_uri_loc, img_name, self.extract_http_body_data(image_data))
                image_count += 1
        print('-' * 20)
        print(str(image_count) + " new images downloaded")
        print('-' * 20)

    def create_file(self, p_host, p_uri, p_filename, p_data):
        f = p_host + p_uri + "/" + p_filename
        if not os.path.isfile(f):
            with open(f, 'wb') as file_handler:
                file_handler.write(p_data)
            file_handler.close()

    def print_hyperlink_set(self):
        for link_element in self.hyperlink_set:
            print(link_element)

    def run(self, p_host, p_uri):

        request = "GET " + p_uri + " HTTP/1.1\r\nHost: " + p_host + "\r\nConnection:close\r\n\r\n"

        # Create directory structure
        self.create_dir(p_host, p_uri)

        # Establish connection and request data
        site_data = self.request_data(p_host, request)
        print("CONNECTED")
        conn_details = self.extract_http_header_data(site_data)
        print(conn_details.decode())

        document = self.extract_http_body_data(site_data)

        print("*" * 40)
        print("CRAWLING " + p_host + p_uri)
        print("*" * 40)

        # Extract link and image data from byte data
        self.extract_hyperlinks(document, p_host, p_uri)
        view_links = input("View found hyperlinks (Y/N)?")
        if view_links:
            self.print_hyperlink_set()

        # Get page image paths from html doc
        self.extract_image_paths(document)
        # Request images and save to directory
        self.request_and_save_images(p_host, p_uri)

    def gethost(self, p_link):
        # Use regex to remove http:// and https://
        if "http" in p_link:
            if "https" in p_link:
                p_link = re.sub("https://", '', p_link)
            else:
                p_link = re.sub("http://", '', p_link)

        # Split link at '/'
        parts = p_link.split('/')
        # Create list of link components
        ['/' + '/'.join(parts[:index + 1]) for index in range(len(parts))]

        # Get host
        return parts[0]

    def geturi(self, p_link):
        # Use regex to remove http:// and https://
        if "http" in p_link:
            if "https" in p_link:
                p_link = re.sub("https://", '', p_link)
            else:
                p_link = re.sub("http://", '', p_link)

        # Split link at '/'
        parts = p_link.split('/')
        # Create list of link components
        ['/' + '/'.join(parts[:index + 1]) for index in range(len(parts))]

        # Add "/" at beginning if not present
        link_uri = "/" + "/".join(parts[1:])
        return link_uri


''' PROGRAM START '''
print("Welcome!")
url_in = input("Please enter URL, e.g. www.gov.cn/english:\t")
curr_depth = 0
max_depth_in = int(input("\nPlease enter a crawling depth\n"
                         "(0 to retrieve only the images from the URL you've provided,\n"
                         "1 to include get images from linked pages, etc.):\t"))


def get_images(p_url, p_curr_depth, p_max_depth):
    new_crawler = CrawlerFinal("Page 0 Crawler")
    split_url = p_url.split('/')
    # Check if url contains "http(s)://" and remove
    re_link_proto = re.search(r'https?://', p_url)
    if re_link_proto:
        for val in split_url:
            if not val:
                split_url.remove(val)
        host = split_url[1]
    else:
        host = split_url[0]
    uri = '/'.join(split_url[1:])
    # Format URI for GET request
    uri = "/" + uri + "/"
    if not uri:
        uri = '/'
    print("Establishing connection to . . . " + socket.getfqdn(host))
    print("Current depth is " + str(p_curr_depth))
    print("Max depth is " + str(p_max_depth))

    new_crawler.run(host, uri)
    page0_links = new_crawler.hyperlink_set
    # Finished pass over one page
    p_curr_depth += 1

    if p_curr_depth <= p_max_depth:
        for link in page0_links:
            get_images(link, p_curr_depth, p_max_depth)


get_images(url_in, curr_depth, max_depth_in)
print("CRAWL COMPLETE!")
