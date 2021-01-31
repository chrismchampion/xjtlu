"""Class used to create new Node objects for graph configuration file.

Because the algorithm requires global knowledge, it can be implemented for
just one node. The solution is output to a file "DijkstraOut.txt".
"""


class Node:

    # Constructor
    def __init__(self, p_id):
        self.node_id = p_id
        self.port_no = 1000 + int(p_id)
        self.prev_node = None
        self.node_adjacency_list = list()
        self.min_distance = float('inf')

    # Comparator methods used by heap queue in Dijkstra algorithm to determine
    # lowest priority element in the queue based on node's min_distance value
    def __cmp__(self, other):
        # self.cmp(self.min_distance, other.min_distance)
        self.__cmp__(other.min_distance)

    def __lt__(self, other):
        self_priority = self.min_distance
        other_priority = other.min_distance
        return self_priority < other_priority

    def get_id(self):
        return self.node_id

    def get_adj_list(self):
        return self.node_adjacency_list

    def get_min_distance(self):
        return self.min_distance

    def set_min_distance(self, p_weight):
        self.min_distance = p_weight

    def to_string(self):
        return "Node " + self.node_id
