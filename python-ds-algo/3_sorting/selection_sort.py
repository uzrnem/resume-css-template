"""
This is code written by Bhagyesh Sunil Patel
on Feb 21nd, 2021
For Selection Sort
"""
def selection_sort(array):
    for c in range(len(array) - 1):
        min_pos = c
        for e in range(c + 1, len(array)):
            if array[min_pos] > array [e]:
                min_pos = e

            if c != min_pos:
                temp = array[min_pos]
                array[min_pos] = array[c]
                array[c] = temp

array = [1, 4, 9, 0, 8, 2, 6, 3, 7, 5]

selection_sort(array)

print(array)
