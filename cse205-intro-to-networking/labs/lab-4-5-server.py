import socket

host = "127.0.0.1"
port = 4567

#create a socket and bind it to the host/port we want to listen on
listenerSocket = socket.socket()
listenerSocket .bind((host,port))

#start listening for incoming connections
listenerSocket.listen(1)
print("Waiting for incoming connections")

#loop and accept incoming connections
while True:
	#accept an incoming connection
	conn, addr = listenerSocket.accept()
	print("incoming connection from: ", addr)

	#receive data and convert it from binary to string type using decode()
	data = conn.recv(1024).decode()
	print("Received data was: ", data)
	
	#resend the received data + the word "echo" appended to it
	conn.sendall((data+" echo").encode())

	#we're done with this request, so close the socket
	conn.close()
