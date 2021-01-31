class Edge:

    # Constructor
    def __init__(self, p_source, p_target, p_weight):
        self.source = p_source
        self.target = p_target
        self.weight = p_weight

    def to_string(self):
        return self.source.get_id() + " -> " + self.target.get_id() + " : " + str(self.weight)

    def get_source(self):
        return self.source

    def get_target(self):
        return self.target

    def get_weight(self):
        return self.weight
