def is_divide_by_zero(func):
    def infinity(a, b):
        if b == 0:
            return "inf"
        return func(a, b)
    return infinity

@is_divide_by_zero
def divide(num1, num2):
    return num1/num2

print("40/0", divide(40, 0))

print("41/12", divide(41, 12))
