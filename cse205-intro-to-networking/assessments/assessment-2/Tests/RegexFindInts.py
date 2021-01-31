import re

'''str1 = "3158 reviews"
regex = re.search('(\d+)', str1)
print(regex.group(0))'''

node_set = set()
node_list = list()

strList = list()
strList.append("Node 1")
strList.append("2\t4")
strList.append("3\t2")
strList.append("Node 2")
strList.append("3\t5")

for string in strList:
    re1 = re.search('(\d+)', string)
    node_name = "Node " + re1.group(0)
    # node_set.add(node_name)
    if node_name not in node_list:
        node_list.append(node_name)

'''for node in node_set:
    print(node)'''

for node in node_list:
    print(node)
