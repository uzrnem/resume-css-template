def my_function(name = "none", age = 28):
  print("name: ", name, ", age: ", age)
my_function("Bhagyesh", 27)
my_function(age = 26)
my_function()

def array(*list):
  print(list)
array("A", "B", "C")

def object(**map):
  print(map)
object(name = "none", age = 28)
