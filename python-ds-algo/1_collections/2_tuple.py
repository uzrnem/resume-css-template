alphabets = ("abc", "pqr", "xyz", "ghi", "lmk", "pqr")
alphabets[2:5] # ('xyz', 'ghi', 'lmk')
alphabets[:4] # ('abc', 'pqr', 'xyz', 'ghi')
alphabets[-4:-1] # ('xyz', 'ghi', 'lmk')

y = list(alphabets) #get list ['abc', 'pqr', 'xyz', 'ghi', 'lmk', 'pqr']
(abc, pqr, *rest, last) = alphabets  # abc pqr ["xyz", "ghi", "lmk"] pqr
number = (3489, 424 , 423)
tuple = alphabets + number # ('abc', 'pqr', 'xyz', 'ghi', 'lmk', 'pqr', 3489, 424, 423)

x = alphabets.count('pqr') #2
x = alphabets.index('pqr') #1

numbers = number * 2 #(3489, 424, 423, 3489, 424, 423)

if "xyz" in alphabets: print("Yes, 'xyz' is in the alphabets tuple")
for x in alphabets: print(x)

del alphabets
