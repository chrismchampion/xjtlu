T = [[11, 12, 5, 2], [15, 6, 10], [10, 8, 12, 5], [12, 15, 8, 6]]
print(f"T[0] = {T[0]}")
print(f"T[1][2] = {T[1][2]}")

# print out entire 2d array
for row in T:
    for col in row:
        print(col, end=" ")
    print()

# Inserting values (parm1: pos, parm2: val)
# T.insert(2, [0, 5, 11, 13, 6])

# Updating values
T[2] = [11, 9]
T[0][3] = 7
