{\rtf1\ansi\ansicpg1252\cocoartf1671\cocoasubrtf100
{\fonttbl\f0\fmodern\fcharset0 Courier;}
{\colortbl;\red255\green255\blue255;\red0\green0\blue0;}
{\*\expandedcolortbl;;\cssrgb\c0\c0\c0;}
\paperw11900\paperh16840\margl1440\margr1440\vieww11900\viewh20500\viewkind0
\deftab720
\pard\pardeftab720\partightenfactor0

\f0\fs26 \cf0 \expnd0\expndtw0\kerning0
# This function has two parameters and no return value\
\
def myFunction( name, sign ):\
    print("Hi, my name is ", name, " and I'm a ", sign)\
    return\
\
myFunction("Chuck", "Leo")\
\
# This function changes the variable you pass in\
\
def passByReferenceExample1( a ):\
    a.append("March")\
    return\
\
myList = ["January", "February"]\
passByReferenceExample1(myList)\
print(myList)\
\
# This function creates a new reference when we assign a = a + 1\
# Thus, the original a is unmodified\
def passByReferenceExample2( a ):\
    a = a + 1\
    return\
\
x = 1\
passByReferenceExample2(x)\
print(x)\
\
# This function returns a value\
def returnValueExample( a ):\
    a = a**2\
    return a\
\
print(returnValueExample(4))\
\
# myList = ["Jan", "Feb", "Mar"]\
# x = findElement( myList, "Jan")\
# This should print "Search Value Found" and x should be 0 when it's finished\
\
# x = findElement( myList, "Aug")\
# This should print "Not Found" and x should be 3 when it's finished}