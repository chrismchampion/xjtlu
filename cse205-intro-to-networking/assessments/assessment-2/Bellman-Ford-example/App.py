from Algorithm import *
from Node import *
from Edge import *

node1 = Node("A")
node2 = Node("B")
node3 = Node("C")
node4 = Node("D")

edge1 = Edge(1, node1, node2)
edge2 = Edge(1, node2, node3)
edge3 = Edge(1, node3, node4)
edge4 = Edge(4, node3, node2)
edge5 = Edge(300, node1, node4)

node1.adjacencyList.append(edge1)
node1.adjacencyList.append(edge2)
node2.adjacencyList.append(edge3)
node3.adjacencyList.append(edge4)
node3.adjacencyList.append(edge2)

vertex_list = [node1, node2, node3, node4]
edge_list = [edge1, edge2, edge3, edge4, edge5]

algorithm = Algorithm()
algorithm.calculate_shortest_paths(vertex_list, edge_list, node1)
algorithm.get_shortest_path_to(node4)

'''node1.adjacencyList.append(edge1)
node1.adjacencyList.append(edge5)
node2.adjacencyList.append(edge2)
node3.adjacencyList.append(edge3)
node3.adjacencyList.append(edge4)'''
