# Create a pool of processes which will cary out tasks submitted to
# it with the Pool class.

# A process pool object which controls a pool of worker processes to which
# jobs can be submitted. It supports asynchronous results with timeouts and
# callbacks and has a parallel map implementation.
import time
from multiprocessing import Pool


def sum_square(number):
    s = 0
    for i in range(number):
        s += i * i
    return s


def sum_square_with_mp(numbers):
    start_time = time.time()
    # parm: num of processors, def = max num
    p = Pool()
    # result is what's returned after calling a specific function
    # function takes a function and list of something and maps all iterables onto processors on machine
    p.map(sum_square, numbers)  # result
    p.close()
    # wait for processes to finish
    p.join()

    end_time = time.time() - start_time
    print(f"Processing {len(numbers)} numbers took {end_time} time using multiprocessing")


def sum_square_no_mp(numbers):
    start_time = time.time()
    result = []
    for i in numbers:
        result.append(sum_square(i))
    end_time = time.time() - start_time
    print(f"Processing {len(numbers)} numbers took {end_time} time using serial processing")


if __name__ == '__main__':

    '''numbers = range(5)  # [0,1,2,3,4]
    # parm: num of processors, def = max num
    p = Pool()
    # result is what's returned after calling a specific function
    # function takes a function and list of something and maps all iterables onto processors on machine
    result = p.map(sum_square, numbers)
    print(result)

    p.close()
    # wait for processes to finish
    p.join()'''

    number_list = range(10000)
    sum_square_with_mp(number_list)
    sum_square_no_mp(number_list)
