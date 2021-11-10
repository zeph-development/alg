# https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
# Arrays: Left Rotation
from collections import Counter


def rotate_left(a, d):
    return a[int(d % len(a)):len(a)] + a[0:int(d % len(a))]


array = [1, 2, 3, 4, 5]
print(rotate_left(array, 9))

# https://www.hackerrank.com/challenges/crush/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
# Array Manipulation

def array_manipulation(n, queries):
    c = Counter()
    for a, b, k in queries:
        c[a] += k
        c[b + 1] -= k
    array_sum = 0
    max_sum = 0
    for i in sorted(c)[:-1]:
        array_sum += c[i]
        max_sum = max(max_sum, array_sum)
    return max_sum


queries = [[1, 5, 3],
           [4, 8, 7],
           [6, 9, 1]]
n = 10

print(array_manipulation(n, queries))
