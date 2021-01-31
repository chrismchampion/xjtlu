import socket

HOST = 'localhost'
PORT = 1001
BUFF = 1024
ADDR = (HOST, PORT)

serversock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
serversock.bind(ADDR)
serversock.listen(2)

while True:
    print("Waiting on connection...")
    clientsock, addr = serversock.accept()
    print(f"Connected from: {addr}")
    while True:
        try:
            data = clientsock.recv(BUFF).decode()
            if not data:
                break
            clientsock.sendall(data.encode())
        except socket.error as err:
            print(f"ERROR: {err}")
        clientsock.close()
    serversock.close()
