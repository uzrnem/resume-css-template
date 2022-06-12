
alphabets = ['abc', 'pqr', 'xyz']
alphabets.append("cde") #['abc', 'pqr', 'xyz', 'cde']

list = ["ghi", "lmk", "pqr"]
alphabets.append(list) #['abc', 'pqr', 'xyz', 'cde', ['ghi', 'lmk', 'nop']]

alphabets.extend(list) #['abc', 'pqr', 'xyz', 'cde', 'ghi', 'lmk', 'nop'] 0

x = alphabets.index("lmk") #6

alphabets.insert(1, "pqr") #['abc', 'pqr', 'pqr', 'xyz', 'cde']

alphabets.pop(1) #['abc', 'pqr', 'xyz', 'cde']

alphabets.remove("pqr") #['abc', 'xyz', 'cde'] remove first occurance

new_list = alphabets.copy() #copy this array
alphabets.clear()

x = new_list.count("pqr") #count on item


new_list.reverse() #['cde', 'xyz', 'abc']

# A function that returns the length of the value:
def sort_by_len(e):
  return len(e)

alphabets = ['io', 'sdfjlk', 'e', 'klf']

alphabets.sort(reverse=True, key=sort_by_len) #['sdfjlk', 'klf', 'io', 'e']
