package main

import "fmt"

type Obj struct {
	Name string
	Age int
}
func main() {
	obj := Obj{Name: "Bhagyesh", Age: 27}
	obj2 := &obj
	obj2.Name = "Shweta"
	fmt.Println(obj)
	fmt.Printf("%T %#v", obj2, obj2)
	// fmt.Println(obj2) # &{Shweta 27}
	// fmt.Println(*obj2) # {Shweta 27}
	// fmt.Println(&obj2) # 0xc0000b4018
}