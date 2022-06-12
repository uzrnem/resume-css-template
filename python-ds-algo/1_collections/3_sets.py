sait = {'abc', 'pqr', 'xyz'}
print(sait)

for x in sait: print(x)

sait.add("pqr") # {'abc', 'pqr', 'xyz'}

othersait = {"ghi", "lmk", "pqr"} #set or any

sait.update(othersait) #{'abc', 'ghi', 'xyz', 'lmk', 'pqr'}
sait.remove("lmk") #RAISE error , {'abc', 'ghi', 'xyz', 'pqr'}
sait.discard("ghi") #no error, {'abc', 'xyz', 'pqr'}
x = sait.pop() # abc
sait.clear() #empty

new_set = {'abc', 'pqr', 'xyz'}

sait = othersait.union(new_set) #{'xyz', 'lmk', 'ghi', 'abc', 'pqr'}

sait.intersection_update(othersait) #{'lmk', 'ghi', 'pqr'}
z = sait.intersection(othersait) #{'pqr', 'lmk', 'ghi'}

new_set.symmetric_difference_update(othersait) # {'ghi', 'abc', 'lmk', 'xyz'}
z = new_set.symmetric_difference(othersait) # {'abc', 'pqr', 'xyz'}
