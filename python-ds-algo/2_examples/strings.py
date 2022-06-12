
s1 = "bhagyesh"
s2 = "patel"
print(s2 in s1) #True
print(s1.__add__(s2)) #bhagyeshpatel
print(type(s2)) #class 'str'

print("bhagyesh sunil patel".split()) #['bhagyesh', 'sunil', 'patel']
print("bhagyesh patel".capitalize()) #Bhagyesh patel
print("Bhagyesh Sunil Patel".istitle()) #True
print("bhagyesh sunil patel".title()) #Bhagyesh Sunil Patel
print('bhagyesh'.translate('a'.maketrans('ge', 'ia'))) #bhaiyash
print ('patel'.partition('te')) #('pa', 'te', 'l')
print("bhagyesh".count('h')) #2
print("bhagyesh".count('h', 1)) #2
print("bhagyesh".count('h', 2)) #1
print("patel".replace("e", "i")) #patil

print("nayan".find("n")) #0
print("nayan".find("a")) #1
print("nayan".find("m")) #-1
print("A" in "A") #True
print('nayan'.split('a', 2)) #['n', 'y', 'n']
print('nayan'.split('a', 1)) #['n', 'yan']
print('nayan'.split('a', 0)) #['nayan']
print("patel".center(5, '-')) # patel
print("patel".center(6, '-')) # patel-
print("patel".center(7, '-')) # -patel-
statement = "bhagyesh"
result = [(i.upper(), statement.count(i)) for i in statement]
print (result) #[('B', 1), ('H', 2), ('A', 1), ('G', 1), ('Y', 1), ('E', 1), ('S', 1), ('H', 2)]
print('patel' in ['Patel']) #False
print(("patel"+'2')*2) #patel2patel2
print("patel"[:2]) #pa
print('patel'[-1:]) #l

print('EMP007'.isalnum()) #True
print('90'.isnumeric()) #True
print(''.isdigit())

print('encode'.encode()) #b'encode'
