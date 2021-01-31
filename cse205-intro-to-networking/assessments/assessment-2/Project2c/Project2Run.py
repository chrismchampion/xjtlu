from Router import *
from multiprocessing import Process
from ImportGraph import *
from Dijkstra import *
# from BellmanFord import *

# File name for testing purposes
graph_config_file = "nodeExample.txt"
# Command line file-name parameter
# graph_config_file = sys.argv[1]

# Import the graph
dijkstra_graph = ImportGraph(graph_config_file)
bf_graph = ImportGraph(graph_config_file)

dijkstra = Dijkstra()
# bellman_ford = BellmanFord()

''' Dijkstra Implementation '''
# Get first node from graph file
dijkstra_start_node = dijkstra_graph.node_list[0]
print("DIJKSTRA")
print("Start node = Node " + dijkstra_start_node.get_id())
print("\tPath\t\tTotal Cost")

dijkstra.calculate_shortest_path(dijkstra_start_node)
fwd_table = dijkstra.get_forwarding_table(dijkstra_graph)
lines = list()
for line in fwd_table:
    print(line)
    lines.append(line + "\n")
dijkstra_graph.write_file(lines, "dijkstra_out.txt")
print("Output <target><[path]><cost> written to 'dijkstra_out.txt'")

''' Bellman-Ford Implementation '''
bf_start_node = bf_graph.node_list[0]
print("\n\nBELLMAN-FORD")
print("Start node = Node " + bf_start_node.get_id())
# Create little routers
for node in bf_graph.node_list:
    proc = Process(target=Router, args=(node,))
    proc.start()
