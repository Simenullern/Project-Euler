package main

import (
	"fmt"
	"math"
	"strconv"
)

func main(){
	counter:= 0
	goal:= 11
	sum:= 0
	currentNum:= 10

	for {
		if (counter == goal){
			break
		}
		var digits[] int
		for j:=0; j<len(strconv.Itoa(currentNum)); j++ {
			charInt, _ := strconv.ParseInt(string(strconv.Itoa(currentNum)[j]), 0, 64)
			digits = append(digits, int(charInt))
		}
		if isTruncatablePrime(digits){
			fmt.Println(currentNum)
			counter++
			sum+=currentNum
		}
		currentNum++
	}
	fmt.Println("answ:", sum)
}

func isTruncatablePrime(numbers []int) bool{
	for i:=len(numbers); i>0; i--{
		if !isSlicePrimed(numbers[0:i]) || !isSlicePrimed(numbers[len(numbers)-i:]){
			return false
		}
	}
	return true
}


func isSlicePrimed(numbers []int) bool{
	var wholeNum string = ""
	for j:=0; j<len(numbers); j++{
		wholeNum += strconv.Itoa(numbers[j])
	}
	intNum, _ := strconv.ParseInt(wholeNum, 0, 64)
	return isPrimed(int(intNum))
}


func isPrimed(val int) bool {
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
