import os
import re
from Node import *
from Edge import *
"""This class is for handling file input/output.

For example, used to read in the program's graph configuration file,
writing Dijkstra output to a file and writing Bellman-Ford DV table output to a file.
"""
# Need to get Nodes from graph config file
# For each Node in NodeList, need to create a new Node object
# Then add Node objects to list called "graph"

# Nodes are "neighbors" if there is an Edge connecting them
# For each neighboring Node, need to get Edge weight


class ImportGraph:

    node_list = list()
    node_id_list = list()
    edge_list = list()
    file_lines = list()

    def __init__(self, file_name):
        self.file_name = file_name
        self.parse_file()
        self.construct_graph()

    @staticmethod
    def write_file(lines, file_name):
        try:
            if os.path.exists(file_name):
                os.remove(file_name)
            with open(file_name, 'a+') as f_out:
                f_out.writelines(lines)
        except IOError as ex:
            print(ex)

    def parse_file(self):
        try:
            with open(self.file_name, 'r') as f_in:
                # Strip out any blank lines
                self.file_lines = list(filter(None, (line.rstrip() for line in f_in)))
        except IOError as ex:
            print(ex)

    def get_line_values(self, line_num):
        int_list = re.findall(r'\d+', self.file_lines[line_num])
        if len(int_list) == 1:
            # return node_id
            return int_list[0]
        # return list ['target_node', 'weight']
        return int_list

    def create_node(self, p_id):
        # if the node doesn't exist yet
        if p_id not in self.node_id_list:
            # Create the node
            node = Node(p_id)
            # print("Created Node " + p_id)
            # Add to node lists
            self.node_list.append(node)
            self.node_id_list.append(node.get_id())

    def create_edge(self, p_src_node, p_target_node, p_weight):

        # Create the edges and add to edge list
        edge_a_to_b = Edge(p_src_node, p_target_node, p_weight)
        #edge_b_to_a = Edge(p_target_node, p_src_node, p_weight)
        self.edge_list.append(edge_a_to_b)
        #self.edge_list.append(edge_b_to_a)
        # Update node adjacency list
        self.update_adjacency_list(p_src_node, edge_a_to_b)
        #self.update_adjacency_list(p_target_node, edge_b_to_a)

    def update_adjacency_list(self, p_node, p_edge):
        for node in self.node_list:
            if node.get_id() == p_node.get_id():
                # Get adjacent node and add to node's adjacency list
                node.get_adj_list().append(p_edge)

    def construct_graph(self):
        i = 0
        curr_node = 0
        while i < len(self.file_lines):
            if "node" in self.file_lines[i].lower():
                node_id = self.get_line_values(i)
                # curr_node = node_id
                self.create_node(node_id)
                curr_node = self.get_node_by_id(node_id)
            else:
                edge = self.get_line_values(i)
                target_id = edge[0]
                # if target node doesn't exist, create it
                if target_id not in self.node_id_list:
                    # print("Target node does not exist yet")
                    self.create_node(target_id)
                target = self.get_node_by_id(target_id)
                weight = float(edge[1])
                source = curr_node
                self.create_edge(source, target, weight)
            i += 1

    def get_node_by_id(self, p_id):
        for node in self.node_list:
            if node.get_id() == p_id:
                return node

    def get_node_list(self):
        return self.node_list

    def get_node_id_list(self):
        return self.node_id_list

    def get_edge_list(self):
        return self.edge_list


'''TEST IMPORT GRAPH'''
'''graph = ImportGraph('nodeExample.txt')

print("Node List:")
for n in graph.node_list:
    print("-" * 20)
    print("Node " + n.get_id())
    print("Adjacent node(s):")
    # print(n.get_adj_list()) // this prints list of node objects at memloc
    for edge in n.get_adj_list():
        print("Node " + edge.get_target().get_id())

print("Edge List:")
print("-" * 20)
for e in graph.edge_list:
    print("Edge: " + e.to_string())'''
