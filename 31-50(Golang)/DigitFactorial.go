package main

import (
	"fmt"
	"strconv"
)

func main(){
	upperLimit := int(factorial(9))*7
	var matches []int

	for i:=3 ; i<upperLimit; i++ {
		var num string = strconv.Itoa(i)
		if int64(i) == getDigitFactorial(num){
			matches = append(matches,i)
			fmt.Println(i)
		}
	}

	answ:= 0
	for _, element := range matches{
		answ += element
	}
	fmt.Println("answ:", answ)
}

func getDigitFactorial(num string) int64{
	var sum int64
	sum= 0
	for _, char := range num {
		charInt, _ := strconv.ParseInt(string(char), 0, 64)
		sum += factorial(charInt)
	}
	return sum
}

func factorial (n int64) int64{
	if n==1 || n==0 {
		return 1
	} else {
		return n*factorial (n-1)
	}
}
