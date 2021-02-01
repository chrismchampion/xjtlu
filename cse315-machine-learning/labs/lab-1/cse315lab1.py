# Listing 1: Basic Python Syntax
a_string = "hello, world"
an_integer = 12
a_float = 3.14
a_boolean = True

print(a_string, an_integer, a_float, a_boolean, "\n")

print('a long statement may be split using backslash',\
      'this is still the same statement', "\n")

x = 10
if x == 10:
    print('x has a value of 10')
else:
    print('x does NOT have a value of 10')

# Listing 2: Examples of lists and dictionaries
myList = [1, 2, 3, 4]

# range() creates a list of numbers between 0 and 10 in increments of 1
# list of numbers 0 to 10
myList2 = range(0, 10, 1)

# this appends the object myList to the end of myList2 - i.e. the last element of #myList 2 is a list
# no it doesn't: AttributeError: 'range' object has no attribute 'append'
# myList2.append(myList)
# print(myList2)
print(len(myList2))

# the sort function can take additional parameters such as a key,
# ascending/decending etc
# AttributeError: 'range' object has no attribute 'sort'
# myList2.sort()

# slicing lists - allows you to select segments of the list
print(myList2[2:4])
# first three elements
print(myList2[:3])

# dict contains key-value pairs
myDict = {'a': 'hello', 'b': 'world'}
print(myDict['a'])
print(myDict['b'])

# Listing 3: Example Python function


# This function outputs the result 1 + 1
def onePlusOne():
    return 1 + 1


# This function prints a passed in string
def printStr(str):
    print(str)
    return


# Function returns sum of input values a and b
def add(a, b):
    return a + b

# Calling functions
x = onePlusOne()
y = add(1, 2)

# Native print function == printStr() function
print(x)
printStr('y')
