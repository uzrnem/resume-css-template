package main

import "fmt"

func main() {
	x := 5
	fmt.Println("pass by value (which create copies of value)")
	y := x
	y = 7
	fmt.Println("Values of x =", x, " and y =", y)
	fmt.Println("Address of x =", &x, " and y =", &y)

	fmt.Println("\npass by reference (stores address/reference of variable)")
	p := &x
	*p = 10
	fmt.Println("Values of x =", x, " and p =", p)
	fmt.Println("Address of x =", &x, " and p =", &p)
}