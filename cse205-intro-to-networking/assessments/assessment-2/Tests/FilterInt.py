str1 = "3158 reviews"
extractInt = int(''.join(list(filter(str.isdigit, str1))))
print(str(extractInt))

strList = list()
strList.append("Node 1")
strList.append("24\t4")
strList.append("3\t2")
strList.append("Node 2")
strList.append("3\t5")

for string in strList:
    extractFirstInt = int(list(filter(str.isdigit, string))[0])
    print(extractFirstInt)
