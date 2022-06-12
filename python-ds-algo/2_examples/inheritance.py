class Parent:
    pass #to declare empty

    def show(this):
        pass # to declare empty

class Base(Parent):
    def __init__(this):
        super().__init__()

    def show(this):
        print("showing")

x = Base()
x.show()
