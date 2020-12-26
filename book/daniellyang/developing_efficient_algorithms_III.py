# Book - Introduction to Java and Data Structures 2020 by Daniel Liang
# Pdf - http://library.lol/main/282EAF31AA3961A91DE404B47064F286

# Chapter 22 - Developing Efficient Algorithms


# Algorithm find the closest points Pair - page 884
import math
from decimal import Decimal
from typing import List

from python.model.point import Point


def swap_points(points, i, j):
    temp: int = points[i]
    points[i] = points[j]
    points[j] = temp


def partition(points: List[Point], left, right):
    i = left + 1
    pivot = points[left].get_x()

    for j in range(left + 1, right + 1):
        if points[j].get_x() < pivot:
            swap_points(points, i, j)
            i += 1

    pos = i - 1
    swap_points(points, left, pos)
    return pos


def quicksort(points: List[Point], left: int, right: int):
    if left < right:
        pivot = partition(points, left, right)
        quicksort(points, left, pivot - 1)
        quicksort(points, pivot + 1, right)


def distance_between_two_points(first_point: Point, second_point: Point) -> Decimal:
    return Decimal(math.sqrt(
        ((first_point.get_x() - second_point.get_x()) ** 2)
        + ((first_point.get_y() - second_point.get_y()) ** 2)))


def extract_left_and_right(points: List[Point], left_points: [], right_points: []):
    mid_index = int(len(points) / 2)
    left_points.extend(points[0:mid_index])
    right_points.extend(points[mid_index:len(points)])


def find_closest_distance_between_two(points: List[Point]) -> Decimal:
    points_length = len(points)
    min_distance = distance_between_two_points(points[0], points[1])
    i = 0
    while i < points_length - 1:
        j = i + 1
        while j < points_length:
            current_distance = distance_between_two_points(points[i], points[j])
            if min_distance > current_distance:
                min_distance = current_distance
            j += 1
        i += 1
    return min_distance


def extract_strips_from(points: List[Point], strip_l: [], strip_r: [], min_strip_distance: Decimal):
    mid_point = points[int(len(points) / 2)]
    mid_point_x = mid_point.get_x()
    for point in points:
        # check if point is in the left or right strip
        if mid_point_x - min_strip_distance <= point.get_x() <= mid_point_x:
            strip_l.append(point)
        elif mid_point_x < point.get_x() <= mid_point_x + min_strip_distance:
            strip_r.append(point)


def find_strips_between_min_distance(strip_l: [], strip_r: [], min_strip_distance: Decimal):
    strip_r_index = 0
    if not strip_r:
        return None
    try:
        for strip_l_point in strip_l:
            while strip_r_index < len(strip_l) \
                    and strip_r[strip_r_index].get_y() <= strip_l_point.get_y() - min_strip_distance:
                strip_r_index += 1
            # check for remaining r index
            while strip_r_index < len(strip_r) \
                    and strip_r[strip_r_index].get_y() - strip_l_point.get_y() <= min_strip_distance:

                current_distance = distance_between_two_points(strip_l_point,
                                                               strip_r[strip_r_index] < min_strip_distance)
                if current_distance < min_strip_distance:
                    min_strip_distance = current_distance
                strip_r_index += strip_r_index
    finally:
        return None


# T(n)=>2T(n/2) + 0(n) => 0(n log n)
def find_closest_pair_distance(points: List[Point]):
    points_len = len(points)

    # sort points by y axis
    quicksort(points, 0, points_len - 1)
    left_sorted_points_by_x = []
    right_sorted_points_by_x = []

    extract_left_and_right(points=points,
                           left_points=left_sorted_points_by_x,
                           right_points=right_sorted_points_by_x)

    # find min distance from the left and right sections
    left_min_dist = find_closest_distance_between_two(points=left_sorted_points_by_x)
    right_min_dist = find_closest_distance_between_two(points=right_sorted_points_by_x)

    # extract strip_l and strip_r
    strip_l_points = []
    strip_r_points = []

    min_strip_distance = min(left_min_dist, right_min_dist)
    extract_strips_from(points=points,
                        strip_l=strip_l_points,
                        strip_r=strip_r_points,
                        min_strip_distance=min_strip_distance)

    find_strips_between_min_distance(strip_l_points, strip_r_points, min_strip_distance)
    print(min_strip_distance)


find_closest_pair_distance(
    [Point(11, 11), Point(13, 8), Point(15, 7),
     Point(10, 2), Point(7, 4), Point(8, 4), Point(2, 2), Point(5, 2),
     Point(6, 7), Point(3, 7),
     Point(2, 10)])
