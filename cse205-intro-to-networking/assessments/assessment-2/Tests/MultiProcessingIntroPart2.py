import time
from multiprocessing import Process
# current_process allows info about curr proc running on machine


def square(nums):

    for num in nums:
        time.sleep(0.5)
        result = num * num
        print(f"The number {num} squares to {result}.")


if __name__ == '__main__':

    processes = []
    numbers = range(100)

    # for loop for instantiating processes and storing in list
    # processes started non-sequentially (asynchronous)
    for i in range(50):
        # parm1: target function we want to dist across processes
        # parm2: args = the parameters that target function takes (req. min 2 arg tuple)
        proc = Process(target=square, args=(numbers,))
        # after creating process object, add it to list of processes
        processes.append(proc)

        # Processes are spawned by creating a process object and
        # then calling its start method.
        proc.start()

    # ensure all processes have completed by converging
    for proc in processes:
        proc.join()

    print("Multiprocessing complete")
