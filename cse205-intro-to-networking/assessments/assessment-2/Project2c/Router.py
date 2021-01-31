import socket
import threading
import time
from multiprocessing import *
from ImportGraph import *


class Router:

    global UPDATE

    host = 'localhost'
    client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    listener_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

    def __init__(self, p_node):
        self.node = p_node
        self.port_no = p_node.port_no

        # listening on a separate thread
        thread = threading.Thread(target=self.listen)
        # sets listen() as parent process
        thread.daemon = True
        thread.start()

        time.sleep(3)
        if len(self.node.node_adjacency_list) > 0:
            self.greet_neighbors(self.node)

        # while loop timer, client/sender
        curr_time = time.time()
        while True:
            if UPDATE:
                UPDATE = False
                self.broadcast(changes)
                curr_time = time.time()
            else:
                if time.time() - curr_time > 5:
                    break

        # save node file instance


    def listen(self):
        # nodes listen on port 1000 + node_id
        self.listener_socket.bind((self.host, self.port_no))
        # start listening for incoming connections
        self.listener_socket.listen(100)
        print(f"Node {self.node.node_id} waiting for incoming connections on port {self.port_no}... ")

        # loop and accept incoming connections
        while True:
            # timeout when no more data received
            self.listener_socket.settimeout(5)
            try:
                conn, addr = self.listener_socket.accept()
                # receive data and convert it from binary to string type using decode
                data = conn.recv(1024).decode()
                # examine function
                # cmp. min dist plus edge weight with curr min distance
                # update global table containing node info and UPDATE flag if smaller
                print(f"Node {self.node.node_id}; Received data was: {data}")
                conn.close()
            except socket.error:
                print(f"Node {self.node.node_id} has stopped listening")
                break

    def broadcast(self, dv_line):
        pass

    # Need to send edge info to adjacent nodes over TCP
    def greet_neighbors(self, p_node):
        # get p_node's neighboring nodes (targets)
        for edge in p_node.node_adjacency_list:
            neighbor = edge.target
            weight = edge.weight
            print(f"Node {self.node.node_id} connecting to {neighbor.node_id}")
            try:
                new_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
                new_socket.connect((self.host, neighbor.port_no))
                new_socket.sendall(p_node.node_id.encode())
                print(new_socket.recv(1024).decode())
                print(f"Hi node {neighbor.node_id}, I'm node {p_node.node_id}")
                # Update neighbor node's min_distance (inf -> edge weight)
                edge.target.min_distance = weight
                print(f"My distance to you is {edge.target.min_distance}")
            except socket.error as err:
                print("ERROR: Node {} to {}".format(self.node.node_id, neighbor.node_id))
                print(err)

    # def client
        # change sending message to dv table line data
        # node_num\tnode1\tmin_distance to node1


''' TESTING THE ROUTER CLASS '''
if __name__ == '__main__':

    graph = ImportGraph("nodeExample.txt")
    for node in graph.node_list:
        proc = Process(target=Router, args=(node,))
        proc.start()
        # proc.join()
