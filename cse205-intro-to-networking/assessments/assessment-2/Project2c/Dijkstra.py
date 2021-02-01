import heapq
from ImportGraph import *
"""This class implements Dijkstra's algorithm (link state).

Dijkstra's algorithm computes least cost paths from one node ('source') to all other nodes,
gives forwarding table for that node.
Because the algorithm requires global knowledge, it can be implemented for
just one node. The solution is output to a file "DijkstraOut.txt".
"""


class Dijkstra:

    # File name for testing purposes
    graph_config_file = "nodeExample.txt"
    # Command line file-name parameter
    # graph_config_file = sys.argv[1]

    # Import the graph
    #dijkstra_graph = ImportGraph(graph_config_file)

    #start_node = dijkstra_graph.node_list[0]


    def __init__(self):
        self.graph = ImportGraph(self.graph_config_file)
        self.start_node = self.graph.node_list[0]

    @staticmethod
    def calculate_shortest_path(start_node):
        # priority queue to store visited nodes
        # prioritized by min_distance, initialized with start node
        prio_queue = []
        start_node.set_min_distance(0)
        heapq.heappush(prio_queue, start_node)

        # 1st run: prio_queue only contains start_node
        while len(prio_queue) > 0:
            # pop node from head of prio_queue
            head_node = heapq.heappop(prio_queue)
            # get the node's outgoing edges
            for edge in head_node.get_adj_list():
                # for each edge, get the source node and target node
                u = edge.get_source()
                v = edge.get_target()
                # add edge weight to source node's distance (init. 0 for starting node)
                new_distance = u.min_distance + edge.weight

                # if the target node's distance is greater than newly calculated distance
                # (Note: initially true for all nodes since nodes are initialized with infinite min_distance)
                if new_distance < v.min_distance:
                    # Assign source node as target node's previous node
                    v.prev_node = u
                    # Update the target node's distance
                    v.min_distance = new_distance
                    # Add the target node to the list of visited nodes
                    heapq.heappush(prio_queue, v)

    @staticmethod
    def get_shortest_path_to(p_target_node):
        # print("Shortest path to target is: ", p_target_node.get_min_distance())
        path = list()
        total_cost_str = str(p_target_node.get_min_distance())
        node = p_target_node
        while node is not None:
            path.append(node.get_id())
            node = node.prev_node
        path.reverse()
        path_str = ", ".join(path)
        return p_target_node.node_id + "\t[" + path_str + "]\t" + total_cost_str

    def get_forwarding_table(self, p_graph):
        lines = list()
        for node in p_graph.get_node_list():
            # destination, path, total cost
            lines.append(self.get_shortest_path_to(node))
            ''' TEST '''
            # print adjacent nodes
            # print(node.node_adjacency_list)
        return lines


dijkstra = Dijkstra()
print("DIJKSTRA")
print("Start node = Node " + dijkstra.start_node.get_id())
print("\tPath\t\tTotal Cost")

dijkstra.calculate_shortest_path(dijkstra.start_node)
fwd_table = dijkstra.get_forwarding_table(dijkstra.graph)
lines = list()

for line in fwd_table:
    print(line)
    lines.append(line + '\n')

dijkstra.graph.write_file(lines, "dijkstra_out.txt")
print("Output <target><[path]><cost> written to 'dijkstra_out.txt'")