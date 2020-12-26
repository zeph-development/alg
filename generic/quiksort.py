def partition(array, left, right):
    i = left + 1  # Initialise i to one more assuming pivot is at position left
    pivot = array[left]

    for j in range(left + 1, right + 1):  # Iterate over the remaining array
        if array[j] < pivot:
            array[i], array[j] = array[j], array[i]  # Swap the values
            i += 1

    pos = i - 1
    array[left], array[pos] = array[pos], array[left]
    return pos


def quicksort(array, left, right):
    if left < right:
        pivot = partition(array, left, right)
        quicksort(array, left, pivot - 1)
        quicksort(array, pivot + 1, right)
