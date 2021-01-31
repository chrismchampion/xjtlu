# A lock or mutex is a synchronization mechanism for enforcing
# limits on access to a resource in an environment where there
# are many threads of execution.
import time
from multiprocessing import Process, Lock, Value

# ex. no_mp
'''def add_500_no_mp(p_total):
    for i in range(100):
        time.sleep(0.01)
        p_total += 5
    return p_total
def sub_500_no_mp(p_total):
    for i in range(100):
        time.sleep(0.01)
        p_total -= 5
    return p_total'''


# ex. no_lock - returns inconsistent results
# b/c total resource accessed out of step
'''def add_500_no_lock(p_total):
    for i in range(100):
        time.sleep(0.01)
        p_total.value += 5
    # no return statement b/c modifying shared resource
def sub_500_no_lock(p_total):
    for i in range(100):
        time.sleep(0.01)
        p_total.value -= 5
    # no return statement b/c modifying shared resource'''


# lock around shared resource ensures manipulation
# occurs sequentially
def add_500_lock(p_total, p_lock):
    for i in range(100):
        time.sleep(0.01)
        p_lock.acquire()
        p_total.value += 5
        p_lock.release()
    # no return statement b/c modifying shared resource


def sub_500_lock(p_total, p_lock):
    for i in range(100):
        time.sleep(0.01)
        p_lock.acquire()
        p_total.value -= 5
        p_lock.release()
    # no return statement b/c modifying shared resource


if __name__ == '__main__':

    # ex. no_mp
    '''total = 500
    print(total)
    total = add_500_no_mp(total)
    print(total)
    total = sub_500_no_mp(total)
    print(total)'''

    # ex. no_lock
    '''total = Value('i', 500)
    add_process = Process(target=add_500_no_lock, args=(total,))
    sub_process = Process(target=sub_500_no_lock, args=(total,))

    add_process.start()
    sub_process.start()
    add_process.join()
    sub_process.join()
    print(total.value)'''

    # ex. lock
    total = Value('i', 500)
    lock = Lock()

    add_process = Process(target=add_500_lock, args=(total, lock))
    sub_process = Process(target=sub_500_lock, args=(total, lock))

    add_process.start()
    sub_process.start()
    add_process.join()
    sub_process.join()
    print(total.value)
