# https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
# 2D Array - DS


def hq_sum(arr: [[]], xs: [], ys: []) -> int:
    hg_current_sum = 0
    for i in range(0, 7):
        hg_current_sum = hg_current_sum + (arr[xs[i]][ys[i]])
        xs[i] += 1
    return hg_current_sum


def hq_line_max_sum(arr: [[]], xs: [], ys: []) -> int:
    hg_line_max_sum = hq_sum(arr, xs, ys)

    for i in range(0, 3):
        hg_current_sum = hq_sum(arr, xs, ys)

        hg_line_max_sum = max(hg_line_max_sum, hg_current_sum)
    return hg_line_max_sum


def reset_xs(xs: []):
    for i, v in enumerate([0, 0, 0, 1, 2, 2, 2]):
        xs[i] = v


def increment_ys_and_reset_xs(xs: [], ys: []):
    reset_xs(xs)
    # increment y line
    for j in range(0, 7):
        ys[j] += 1


def hourglass_sum(arr):
    xs = [0, 0, 0, 1, 2, 2, 2]
    ys = [0, 1, 2, 1, 0, 1, 2]

    hg_max_sum = hq_line_max_sum(arr, xs, ys)

    increment_ys_and_reset_xs(xs, ys)

    for i in range(0, 3):
        line_max_sum = hq_line_max_sum(arr, xs, ys)
        hg_max_sum = max(hg_max_sum, line_max_sum)

        increment_ys_and_reset_xs(xs, ys)

    return hg_max_sum


arr = [[1, 1, 1, 0, 0, 0],
       [0, 1, 0, 0, 0, 0],
       [1, 1, 1, 0, 0, 0],
       [0, 0, 2, 4, 4, 0],
       [0, 0, 0, 2, 0, 0],
       [0, 0, 1, 2, 4, 0]]

print(hourglass_sum(arr))

arr = [[0, -4, -6, 0, -7, -6],
       [-1, -2, -6, -8, -3, -1],
       [-8, -4, -2, -8, -8, -6],
       [-3, -1, -2, -5, -7, -4],
       [-3, -5, -3, -6, -6, -6],
       [-3, -6, 0, -8, -6, -7]]

print(hourglass_sum(arr))
