details = {
  "name": "Bhagyesh",
  "city": "Pune",
  "year": 1994
}
len(details) # 3
details.keys() # dict_keys(['name', 'city', 'year'])
details.values() # dict_values(['Bhagyesh', 'Pune', 1994])
details.get("city") # Pune

details.update({"age": 27})
details.update({"year": 2020}) # {'name': 'Bhagyesh', 'city': 'Pune', 'year': 2020, 'age': 27}
details.items() # dict_items([('name', 'Bhagyesh'), ('city', 'Pune'), ('year', 2020), ('age', 27)])
details.pop("city") # {'name': 'Bhagyesh', 'year': 2020, 'age': 27}
details.popitem() # {'name': 'Bhagyesh', 'year': 2020}
del details["year"] # {'name': 'Bhagyesh'}

for x in details:
  print(9, x , details[x]) #brand Ford
details.clear()

mydict = dict(details)
mydict = details.copy()
