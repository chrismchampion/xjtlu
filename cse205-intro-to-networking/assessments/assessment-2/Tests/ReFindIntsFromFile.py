import re


re_node_num = r'\d+'
# re_weight = r'\d+\s+(\d+)'

# This works for getting adjacency lines
# Group 1 = node; Group 2 = weight
regex = r'^(\d+)\s+?(\d+)?$'

'''for line in open('nodeExample.txt', 'r'):
    node_num = re.search(re_node_num, line)
    print("Node: " + node_num.group(0))

    weight = re.search(r'\d+\s+(\d+)', line)
    if weight:
        print("Weight: " + weight.group(1))'''

for line in open('nodeExample.txt', 'r'):
    crap = re.search(regex, line)
    if crap:
        print(crap.group(1))
    # if crap.group(1):
      #  print("Weight: " + crap.group(1))
