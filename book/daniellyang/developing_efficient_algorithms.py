# Book - Introduction to Java and Data Structures 2020 by Daniel Liang
# Pdf - http://library.lol/main/282EAF31AA3961A91DE404B47064F286

# Chapter 22 - Developing Efficient Algorithms

import math
import random


# T(n) = (a constant c) * n = O(n)
def bo_n(array):
    for idx_i, i in enumerate(array):
        print("column: {}, value: {}".format(idx_i, i))
    print()


generic_message = lambda idx_i, idx_j, j: "column: {}, row: {}, value: {}".format(idx_i, idx_j, j)


# T(n) = c * 5 * n => O(n)
def bo_n_a(array):
    for idx_i, i in enumerate(array):
        for idx_j in range(0, 5):
            print(generic_message(idx_i, idx_j, random.random()))
    print()


# T(n) = n * c + n * 5 * c => O(n)
def bo_n_b(array):
    for idx_i, i in enumerate(array):
        print(generic_message(idx_i, '_', random.random()))
    for idx_i, i in enumerate(array):
        for idx_j in range(0, 5):
            print(generic_message(idx_i, idx_j, random.random()))
    print()


# T(n) = if test time + worst case time (if clause, else clause) => O(n) + O(n) = O(n)
def bo_n_c(array):
    if '3' in array:
        print("Found!")
    else:
        for item in array:
            print(item)
    print()


# T(n) = (a constant c) * n * n = O(n^2)
def bo_nxn(double_array):
    for idx_i, i in enumerate(double_array):
        for idx_j, j in enumerate(i):
            print(generic_message(idx_i, idx_j, j))
    print()


# T(n) = c + 2c + 3c + 4c + ... + nc => cn(n+1)/2 => (cn^2 + cn)/2 => (c/2)n^2 + (c/2)n => O(n^2)
def bo_nxn_a(double_array):
    for idx_i, i in enumerate(double_array):
        for idx_j, j in enumerate(i[idx_i:len(i)]):
            print(generic_message(idx_i, idx_j, j))
    print()


# T(n) => O(a^n)
def bo_a_power_n(a, n):
    result = 1
    for _ in range(0, n):
        result *= a
    print(result)


# T(n) => n = 2^k => k = log n => O(log n)
def bo_a_power_n_perfect_square(a, n):
    result = a
    k = int(math.log2(n))
    for _ in range(0, k):
        result *= result
    print(result)


bo_n([[2, 3]])
bo_n_a([2, 3, 4, 5, 33, 1])
bo_n_b([2, 3, 4])
bo_n_c([2, 3, 33])
bo_nxn([[2, 3], [4, 5]])
bo_nxn_a([[2, 3, 10, 44, 122, 122], [4, 5, 12, 33, 56, 78], [6, 7, 8, 123, 34, 35]])

bo_a_power_n(2, 8)
bo_a_power_n_perfect_square(2, 8)

bo_a_power_n(2, 16)
bo_a_power_n_perfect_square(2, 16)

bo_a_power_n(2, 32)
bo_a_power_n_perfect_square(2, 32)
