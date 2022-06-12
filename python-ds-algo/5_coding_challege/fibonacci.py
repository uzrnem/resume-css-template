def recc(c):
    if c < 1:
        print(0, end=" ")
    elif c < 3:
        print(1, end=" ")
    else:
        print((recc(c - 1) + recc(c -2)), end=" ")

def fibbo(c):
    a = 0
    b = 1
    print(a, end=" ")
    print(b, end=" ")
    while b < c :
        a, b = b, b + a
        print(b, end=" ")

recc(50)
# fibbo(50)
