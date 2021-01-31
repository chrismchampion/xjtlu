while True:
    eingabe = int(input("Enter a number "))

    if eingabe == 0:
        break

    num = 1
    while eingabe >= 1:
        num = num * eingabe
        eingabe = eingabe - 1

    print(num)

    if num % 2 == 0:
        print("Yay, even")
    else:
        print("Boo, odd")
