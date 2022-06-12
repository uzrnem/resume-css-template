"""
This is code written by Bhagyesh Sunil Patel
on Feb 22nd, 2021
For Binary Search
"""
def binary_search(arr, num, start, end):
    mid = int((start+end)/2)
    print("start:", start, ", mid:", mid,", end:",end)
    if start == mid:
        return arr[mid] == num
    if (arr[mid] == num):
        return True
    elif (arr[mid] > num):
        return binary_search(arr, num, start, mid)
    else:
        return binary_search(arr, num, mid, end)

array = [1, 3, 4, 5, 7, 8, 9, 10, 13, 15, 16, 17, 19, 31, 34, 56, 89]

print("16 :", binary_search(array, 16, 0, len(array)))
print("89 :", binary_search(array, 89, 0, len(array)))
print("100 :", binary_search(array, 100, 0, len(array)))
"""
for i in range(100):
    result = binary_search(array, i, 0, len(array))
    if result == True:
        print()
        print(i,"found in list")
    else:
        print(i , end=", ")
"""
