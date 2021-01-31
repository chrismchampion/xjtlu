import re

re_node_id = r'(\d+)'
# This works for getting adjacency lines
# Group 1 = node; Group 2 = weight
# re_edge = r'^(\d+)\s+?(\d+)?$'

with open('nodeExample.txt', 'r') as f_in:
    # Strip out any blank lines
    file_lines = list(filter(None, (line.rstrip() for line in f_in)))

print(file_lines)

for item in file_lines:
    match = re.findall(re_node_id, item)
    #a = match.group(0)
    #print(a)
    if len(match) == 1:
        print("node line")
    else:
        print("edge")
    #print(match[0])
    print(match)
