from multiprocessing.connection import Listener, Client
from array import array
''' The following server code creates a listener which uses 'secret password' as an authentication key.
It then waits for a connection and sends some data to the client: '''
address = ('localhost', 6000)   # family is deduced to be 'AF_INET' from tuple format

with Listener(address, authkey=b'secret password') as listener:

        with listener.accept() as conn:
            print('connection accepted from', listener.last_accepted)
            conn.send([2.25, None, 'junk', float])
            conn.send_bytes(b'Hello')
            conn.send_bytes(array('i', [42, 1729]))

''' The following code connects to the server and receives some data from the server: '''
with Client(address, authkey=b'secret password') as conn:
    print(conn.recv())  # => [2.25, None, 'junk', float]

    print(conn.recv_bytes())    # => 'hello'

    arr = array('i', [0, 0, 0, 0, 0])
    print(conn.recv_bytes_into(arr))    # => 8
    print(arr)  # => array('i', [42, 1729, 0, 0, 0])
