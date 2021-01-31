class Algorithm:

    # Flag for negative weight cycle detection
    HAS_CYCLE = False

    def calculate_shortest_paths(self, vertex_list, edge_list, start_vertex):

        start_vertex.min_distance = 0

        # -1 because bf algorithm dictates max iterations = |V|-1
        for i in range(0, len(vertex_list)-1):

            for edge in edge_list:

                u = edge.start_vertex
                v = edge.target_vertex
                new_distance = u.min_distance + edge.weight

                # relaxation process
                if new_distance < v.min_distance:
                    v.min_distance = new_distance
                    # must set for backtracking
                    v.predecessor = u

        # after |V|-1 iterations, final iteration to
        # check for negative weight cycles
        for edge in edge_list:
            if self.has_cycle(edge):
                print("Negative cycle detected")
                self.HAS_CYCLE = True
                return

    @staticmethod
    def has_cycle(edge):
        # if we run calculate_shortest_paths for one final iteration and a min_distance value decreases,
        # it means there is a negative cycle
        if edge.start_vertex.min_distance + edge.weight < edge.target_vertex.min_distance:
            return True
        else:
            return False

    def get_shortest_path_to(self, target_vertex):

        if not self.HAS_CYCLE:
            print("Shortest path to target vertex: ", target_vertex.min_distance)
            node = target_vertex
            # while loop breaks when it reaches start node (has no predecessor)
            while node is not None:
                print("$s -> ", node.name)
                node = node.predecessor
