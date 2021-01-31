import sys
from ImportGraph import *
from Dijkstra import *
# from BellmanFord import *

graph_config_file = sys.argv[1]

# Import the graph
graph = ImportGraph(graph_config_file)
dijkstra = Dijkstra()
# bellman_ford = BellmanFord()

''' Dijkstra Implementation '''
# Get first node from graph file
start_node = graph.node_list[0]
print("DIJKSTRA")
print("Start node = Node " + start_node.get_id())
print("\tPath\t\tTotal Cost")

dijkstra.calculate_shortest_path(start_node)
fwd_table = dijkstra.get_forwarding_table(graph)
lines = list()
for line in fwd_table:
    print(line)
    lines.append(line + "\n")
graph.write_file(lines, "dijkstra_out.txt")
print("Output <target><[path]><cost> written to 'dijkstra_out.txt'")
