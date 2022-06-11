package main

import "fmt"

type Obj struct {
	Name string
	Age int
}

func method(obj *Obj) {
	obj.Name = "Shweta"
	fmt.Printf("method: %p\n", obj)
	fmt.Printf("method: Name: %#v Age: %#v \n", obj.Name, obj.Age)
}
func main() {
	obj := Obj{Name: "Bhagyesh", Age: 27}
	//obj2 := &obj
	//obj2.Name = "Shweta"
	method(&obj)
	fmt.Printf("main: %p\n", &obj)
	fmt.Printf("%T %#v", obj, obj)
	// fmt.Println(obj2) # &{Shweta 27}
	// fmt.Println(*obj2) # {Shweta 27}
	// fmt.Println(&obj2) # 0xc0000b4018
}