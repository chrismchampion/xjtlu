from multiprocessing import Process
from multiprocessing.connection import Listener, Client

''' Setting up connection between independent processes '''


def handle_client(c):
    while True:
        msg = c.recv()
        c.send(msg)


def echo_server(address, authkey):
    server_c = Listener(address, authkey=authkey)
    while True:
        client_c = server_c.accept()
        p = Process(target=handle_client, args=(client_c,))
        p.daemon = True
        p.start()


if __name__ == '__main__':
    echo_server(('', 16000), b'peakaboo')

''' Connect to the server and send/receive messages '''

c = Client(('localhost', 16000), authkey=b'peakaboo')
c.send("Hello, boo boo")
c.recv()

'''c.send([1, 2, 3, 4])
c.recv()

c.send({'name': 'Dave', 'email': 'dave@dabeaz.com'})
c.recv()'''
