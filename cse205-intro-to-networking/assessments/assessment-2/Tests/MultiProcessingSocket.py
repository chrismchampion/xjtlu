import time
from multiprocessing import Process, Event
import socket


class Server(Process):

    def __init__(self):
        super(Server).__init__()

        self.s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
        self.s.bind(('localhost', 9999))
        self.s.listen(1)
        self.s.settimeout(10)
        self.is_stop = Event()
        self.is_stop.clear()

    def run(self):
        while not self.is_stop.is_set():
            print(f"Server: running {self.pid}")
            time.sleep(1)
        print("Server: exiting")

    def stop(self):
        self.is_stop.set()
        self.s.shutdown(socket.SHUT_RDWR)
        self.s.close()

class Launcher(Process):

    def __init__(self):
        super(Launcher).__init__()
        self.srv = Server(9999)
        self.srv.start()

    def run(self):
        print(f"Launcher {self.pid}")
        while True:
            time.sleep(1)

    def stop(self):
        print("Launcher: I'm stopping the server")
        self.srv.stop()
        self.srv.terminate()
        self.srv.join()
        print("Launcher: server stopped")

class DoNothing(Process):
    def __init__(self):
        super(DoNothing, self).__init__()

    def run(self):
        while True:
            time.sleep(1)


l = Launcher()
l.start()

dn = DoNothing()
dn.start()

time.sleep(2)

print("Stop launcher")
