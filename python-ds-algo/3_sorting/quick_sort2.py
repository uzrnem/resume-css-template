def partion(arr, low, high):
    pivot = array[high - 1]
    border = low - 1
    for j in range (low, high - 1):
        if (arr[j] < pivot):
            if (arr[j] < arr[border + 1]):
                border = border + 1
                swap(arr, border, j)

    border = border + 1
    if (arr[high - 1] < arr[border]):
        swap(arr, border, high - 1)
    return border

def divide_and_merge(arr, low, high):
    if (low < high):
        p = partion(arr, low, high)
        divide_and_merge(arr, low, p)
        divide_and_merge(arr, p+1, high)

def swap(arr, pos1, pos2):
    array = []
    for i in range(0, len(arr)):
        if i == pos1:
            array.append(arr[pos1])
        elif i == pos2:
            array.append(arr[pos2])
        else:
            array.append("")
    arr[pos1], arr[pos2] = arr[pos2], arr[pos1]
    print(array)

array = [41, 17, 5, 29, 54, 6, 22, 3, 13]
print ("Un-Sorted array is:", array)
divide_and_merge(array, 0, len(array))
print ("Sorted array is:", array)
