# Book - Introduction to Java and Data Structures 2020 by Daniel Liang
# Pdf - http://library.lol/main/282EAF31AA3961A91DE404B47064F286

# Chapter 22 - Developing Efficient Algorithms


fibonacci_array = [0, 1]


# Fibonacci
# T(n) = T(n-1) + T(n-2) + c => 2T(n-1) + c => 2(2T(n - 2) + c) + c => 2^2T(n-2) + 2c + c => O(2^n)
def fibonacci(n):
    if n <= 0:
        print("Incorrect input")
    elif n <= len(fibonacci_array):
        return fibonacci_array[n - 1]
    else:
        temp_fib = fibonacci(n - 1) + fibonacci(n - 2)
        fibonacci_array.append(temp_fib)
        return temp_fib


fibonacci(9)
print(fibonacci_array)


# Euclid greatest common divisor
def greatest_common_divisor_method(m: int, n: int):
    greatest_common_divisor = 1
    if m % n == 0:
        return n
    k: int = int(m / 2)
    while k >= 1:
        if m % k == 0 and n % k == 0:
            greatest_common_divisor = k
            break
        k -= 1
    return greatest_common_divisor


print(greatest_common_divisor_method(140, 70))


