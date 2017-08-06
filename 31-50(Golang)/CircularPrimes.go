package main

import (
	"fmt"
	"math"
	"strconv"
)

func main(){
	count:=0
	sum:= 0
	lim:=1000000

	for i:=2; i<=lim; i++{
		if isPrime(i){
			if (isCircularPrime(i)){
				count++
				sum+=i
			}
		}
	}
	fmt.Println("answ:", count, "sum:", sum)
}

func isCircularPrime(number int) bool{
	var digits []int
	for _, char := range strconv.Itoa(number) {
		charInt, _ := strconv.ParseInt(string(char), 0, 64)
		digits = append(digits, int(charInt))
	}
	numberOfRotations := len(digits)-1
	for i:=0; i<numberOfRotations; i++{
		lastElement:= digits[len(digits)-1]
		for j:=len(digits)-1; j>0; j--{
			digits[j] = digits[j-1]
		}
		digits[0] = lastElement
		if !isSlicePrime(digits){
			return false
		}
	}
	return true
}

func isSlicePrime(numbers []int) bool{
	var wholeNum string = ""
	for j:=0; j<len(numbers); j++{
		wholeNum += strconv.Itoa(numbers[j])
	}
	intNum, _ := strconv.ParseInt(wholeNum, 0, 64)
	return isPrime(int(intNum))
}

func isPrime(val int) bool {
	if val < 2 {
		return false
	}
	for i := 2; i <= int(math.Floor(math.Sqrt(float64(val)))); i++ {
		if val%i == 0 {
			return false
		}
	}
	return true
}
