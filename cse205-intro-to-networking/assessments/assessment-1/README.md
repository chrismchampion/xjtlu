# CSE205 Project 1 Report		AY 2018-19 S1

Name: Christopher Champion
Student ID: 1719247
Email: C.Champion17@student.xjtlu.edu.cn

## Implementation

The following functionality has been implemented in the accompanying CrawlerFinal.py file:
1.	Connect to the supplied URL over a TCP sockets, handling requests, server replies, document parsing, and data processing using the built-in Python libraries: socket, re, and os. Additional testing was done using www.xjtlu.edu.cn and www.gov.cn/english.
2.	Downloading all images from the requested page(s).
3.	Recursion: Additional testing required involving socket timeouts and a larger variety of URLs.

The following assigned objectives were not implemented:
•	Multithreading
•	Support of HTTPS over SSL/TLS using the built-in ssl library.

Sources
https://docs.python.org/3.7/howto/sockets.html
https://docs.python.org/3/library/re.html#regular-expression-syntax
https://stackoverflow.com/questions/37378647/receiving-an-image-using-python-3-sockets
https://www.pythonsheets.com/notes/python-socket.html
https://stackoverflow.com/questions/29717424/python-converting-url-into-directory
https://stackoverflow.com/questions/8236020/searching-images-files-with-regular-expressions