import sys


class Node:

    def __init__(self, name):
        self.name = name
        # self.visited = False
        self.adjacencyList = []
        self.predecessor = None
        self.min_distance = sys.maxsize
