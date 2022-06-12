square = lambda a: a * a
print("square of 5: ", square(5))

def power(range):
  return lambda a : a * range

number_of = power(3)
print("Power of 3, to 4 is ", number_of(4))
