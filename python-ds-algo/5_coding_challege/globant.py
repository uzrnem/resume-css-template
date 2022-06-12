#input : = "a,b$cd#ef%"
#output: = "f,e$cd#ba%"
def get_new_pointer(s, pointer, change):
    while pointer < len(s) or pointer > 0:
        if (s[pointer].isalpha()):
            return pointer
        pointer = pointer + change

def format(s, low, high):
    while (low < high):
        low = get_new_pointer(s, low, 1)
        high = get_new_pointer(s, high, -1)
        if (low < high):
            low_s = s[low]
            high_s = s[high]
            s = s[:low] + high_s + s[low+1:]
            s = s[:high] + low_s + s[high+1:]
        low = low + 1
        high = high - 1
    return s

s = "a,b$cd#ef%"
print("Output is: ", format(s, 0, len(s)-1))
