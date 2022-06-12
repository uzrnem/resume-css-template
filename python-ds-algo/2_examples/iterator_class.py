class Movies:
    def __init__(this, list):
        this.__list = list

    def __iter__(this):
        this.__pointer = 0;
        return this

    def __next__(this):
        if this.__pointer < len(this.__list):
            item = this.__list[this.__pointer]
            this.__pointer = this.__pointer + 1
            return item
        else:
            raise StopIteration

    def __len__(this):
        return len(this.__list)

    def __contains__(this, item):
        return item in this.__list

    def __str__(this): #first priority, for print method
        return str(this.__list)

    # print our string object
    def __repr__(this): #first priority, for console
        return 'Movies: {}'.format(this.__list)

    def __add__(this, item):
        return this.__list.append(item)


movies = Movies(["vol", "vol back"])
print(len(movies)) # 3
print("vol 1" in movies) # True
print("vol 2" not in movies) # False

myiter = iter(movies)
print("just print, ", next(myiter))
movies + "vol again"
print("just print, ", next(myiter))
for x in myiter:
  print("for loop, ", x)

for x in movies:
  print("for myclass, ", x)

print(movies)
