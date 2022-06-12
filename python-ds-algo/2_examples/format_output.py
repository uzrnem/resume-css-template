print('Im {0}, {1}'.format('Bhagyesh', 'Software Engineer')) # Im Bhagyesh, Software Engineer
print('Im {}, {}'.format('Bhagyesh', 'Software Engineer')) # Im Bhagyesh, Software Engineer
print("Im {0!r}, {1!s}".format('Bhagyesh', 'Software Engineer')) # Im 'Bhagyesh', Software Engineer
t= 'Im %(a)s, %(b)s'
print(t % dict(a='Bhagyesh', b='Bhagyesh')) # Im Bhagyesh, Software Engineer
print('%d %s is equals to %.2f' % (2, 'pi', 6.28)) #2 pi is equals to 6.28

print("no new line after statement", end = '')

age = 1994
name = "Bhagyesh"
text = "My name is {0}. {0} since {1}."
print(text.format(name, age))

text = "My name is {name}. {name} since {year}."
print(text.format(year = age, name = name))
