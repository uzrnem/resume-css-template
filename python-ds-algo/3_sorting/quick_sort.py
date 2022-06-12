def divide_and_merge(array, start, end):
    if ((start + 1) >= end):
        return
    pivot = array[start]
    border = start
    pointer = border + 1
    while (pointer < end):
        if array[pointer] < pivot and border != pointer:
            border = border + 1
            if (border != pointer) :
                print ("inner[", array[pointer], array[border], "]", array)
                array[pointer], array[border] = array[border], array[pointer]
        pointer = pointer + 1

    print("start:", start, ", end:", end, "border:", border, ", pointer:", pointer)
    if (start != border) :
        print ("outer[", array[start], array[border], "]", array)
        array[start], array[border] = array[border], array[start]

    divide_and_merge(array, start, border)
    divide_and_merge(array, border + 1, end)
    pass

array = [41, 17, 5, 29, 54, 6, 22, 3, 13] #17, 41, 5, 22, 54, 6, 29, 3, 13
print ("Un-Sorted array is:", array)
divide_and_merge(array, 0, len(array))
print ("Sorted array is:", array)
