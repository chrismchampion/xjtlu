import re

node_list = list()


def get_line_values(line_num):
    int_list = re.findall(r'\d+', file_lines[line_num])
    if len(int_list) == 1:
        # return node_id
        return int_list[0]
    # return list ['target_node', 'weight']
    return int_list


def create_node(p_id):
    # if the node doesn't exist yet
    if p_id not in node_list:
        # Create the node
        print("Created Node " + p_id)
        # Add to node list
        node_list.append(p_id)


def create_edge(p_src, p_target, p_weight):
    # if target node doesn't exist, then create it (node.get_id)
    if p_target not in node_list:
        # Create the node and add to node list
        print("Target node does not exist yet")
        create_node(p_target)
        node_list.append(p_target)
    # Create the edge
    print("Created edge - Source Node: " + p_src + "\tTarget Node: " + p_target + "\tWeight: " + p_weight)


with open('nodeExample.txt', 'r') as f_in:
    # Strip out any blank lines
    file_lines = list(filter(None, (line.rstrip() for line in f_in)))

i = 0
curr_node = 0
while i < len(file_lines):
    if "node" in file_lines[i].lower():
        node_id = get_line_values(i)
        curr_node = node_id
        create_node(node_id)
    else:
        edge = get_line_values(i)
        target = edge[0]
        weight = edge[1]
        source = curr_node
        create_edge(source, target, weight)
    i += 1
