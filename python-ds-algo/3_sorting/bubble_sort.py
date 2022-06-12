def bubble_sort(arr):
    n = len(arr)
    for i in range(n-1):
        for j in range(0, n - i - 1):
            if arr[j] > arr[j+1] :
                arr[j+1], arr[j] = arr[j], arr[j+1]

array = [1, 4, 9, 0, 8, 2, 6, 3, 7, 5]

bubble_sort(array)

print ("Sorted array is:", array)
