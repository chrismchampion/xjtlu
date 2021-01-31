import os
from multiprocessing import Process, current_process
# current_process allows info about curr proc running on machine


def square(num):
    result = num * num
    print(f"The number {num} squares to {result}.")

    # Process id is assigned to the call of this function by the OS.
    proc_id = os.getpid()
    print(f"Process ID: {proc_id}.")

    # We can also use the "current_process()" function to get the name
    # of the Process object.
    proc_name = current_process().name
    print(f"Process name: {proc_name}.")


if __name__ == '__main__':

    processes = []
    numbers = [1, 2, 3, 4]

    # for loop for instantiating processes and storing in list
    # processes started non-sequentially (asynchronous)
    for number in numbers:
        # parm1: target function we want to dist across processes
        # parm2: args = the parameters that target function takes (req. min 2 arg tuple)
        proc = Process(target=square, args=(number,))
        # after creating process object, add it to list of processes
        processes.append(proc)

        # Processes are spawned by creating a process object and
        # then calling its start method.
        proc.start()
