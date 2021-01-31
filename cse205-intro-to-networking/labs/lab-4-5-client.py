import socket

host = "127.0.0.1"
port = 4567

#create a socket and connect to the host/port
clientSocket = socket.socket()
clientSocket.connect((host,port))

#user input
message = input("Enter a message: ")

#send the user's input to the server. encode the string as binary using encode()
clientSocket.sendall(message.encode())

#receive the server's reply, decode it from binary to string, and print it
print(clientSocket.recv(1024).decode())

#we're done, so close the socket
clientSocket.close()
