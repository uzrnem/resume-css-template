import json
import os

obj = {
  "name": "Bhagyesh Patel",
  "year": 1994,
  "Engineer" : True,
  "gadget": [
    "OnePlus", "Apple"
  ],
  "city": "Jalgaon"
}
# convert into JSON:
str = json.dumps(obj, indent=4) # params , indent=2, separators=(". ", " = "), sort_keys=True
# the result is a JSON string:
print("formatted json:", str)

# parse strx:
obj2 = json.loads(str)
# the result is a Python dictionary:
print("year of birth: ", obj2["year"])

# use four indents to make it easier to read the result:
f = open("jsonfile.json", "x")
f.write(str)
f.close()

f = open("jsonfile.json", "r")
print("reading file: ", f.read())
f.close()

#"x" - Create - will create a file, returns an error if the file exist
#"a" - Append - will create a file if the specified file does not exist
#"w" - Write - will create a file if the specified file does not exist

print("deleting file: ", os.remove("jsonfile.json"))
