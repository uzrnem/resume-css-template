# Program for Merge-Sort
def merge_sort(array, start, mid, end):
    left = start # left array pointer
    right = mid # right array pointer
    temp = [] # prepare temp array for merging two sorted arrays

    while (left < mid and right < end): # while we have element in both array check both
        if array[left] < array[right]: # put lowest to temp
            temp.append(array[left])
            left = left + 1
        else:
            temp.append(array[right])
            right = right + 1

    temp.extend(array[left:mid]) # put remaining left array to temp
    temp.extend(array[right:end]) # put remaining right array to temp
    array[start:end] = temp # update temp array in original

def divide_and_merge(array, start, end):
    if ((start + 1) < end): # until given array has two element for divide and merge
        mid = int((start + end)/2)

        divide_and_merge(array, start, mid)
        divide_and_merge(array, mid, end)

        merge_sort(array, start, mid, end)

array = [1, 4, 9, 0, 8, 2, 6, 3, 7, 5]
print ("Un-Sorted array is:", array)
divide_and_merge(array, 0, len(array))
print ("Sorted array is:", array)
