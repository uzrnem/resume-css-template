class DivideByZeroException(Exception):
    def __init__(this, *args):

        # Call the base class constructor with the parameters it needs
        super().__init__(args)

        if args:
            this.message = args[0]
        if len(args) > 1:
            this.errors = args[1]

def is_divide_by_zero(func):
    def infinity(a, b):
        if b == 0:
            raise DivideByZeroException("Zero not allowed")
        return func(a, b)
    return infinity

@is_divide_by_zero
def divide(num1, num2):
    return num1/num2
try:
    print("40/0", divide(40, 0))
except DivideByZeroException as err:
    print("DivideByZeroException error_message: {0}".format(err.message))

print("41/12", divide(41, 12))
