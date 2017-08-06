package main

import "fmt"
import "strconv"

func main(){
	var nonTrivNumerators []int
	var nonTrivDenominators []int

	for i:=10; i<50; i++{ // only need to loop to 50 to avoid counting dups
		for j:=10; j<100; j++{
			var iIndex, jIndex int = getCommoner(i, j)
			if (iIndex != -1 || jIndex !=-1){
				var cancelledVal float32 = getCancelledVal(i,j, iIndex, jIndex)
				//fmt.Println("i:", i, "j:", j, " - ", iIndex, jIndex , "-", "cancelled val:", cancelledVal, " - ", "i/j:",float32(i)/float32(j))
				if cancelledVal == float32(i)/float32(j) && i!= j && i%10!=0{
					nonTrivNumerators = append(nonTrivNumerators, i)
					nonTrivDenominators = append(nonTrivDenominators, j)
				}
			}
		}
	}
	printSlice(nonTrivNumerators)
	printSlice(nonTrivDenominators)
	num, denom:= getProduct(nonTrivNumerators, nonTrivDenominators) // will always be smaller than 1
	product:= float64(num)/float64(denom)
	//brute forced
	for x:=1; x<99999999; x++{ // some arbitrary big enough number
		for y:=1; y<x; y++{
			if float64(y)/float64(x) == product {
				fmt.Println("answ is:",y, "/", x)
				return
			}
		}
	}
}

func getProduct (nums []int, denoms []int) (int, int){
	numerator:= 1
	denominator:= 1
	for i:=0; i<len(nums); i++ {
		numerator *= nums[i]
		denominator *= denoms[i]
	}
	return numerator,denominator
}

func getCommoner(s1 int, s2 int) (int, int){
	// returns indexes of common val
	if string(strconv.Itoa(s1)[0]) == string(strconv.Itoa(s2)[0]) {
		return 0,0
	} else if string(strconv.Itoa(s1)[0]) == string(strconv.Itoa(s2)[1]){
		return 0,1
	} else if string(strconv.Itoa(s1)[1]) == string(strconv.Itoa(s2)[0]){
		return 1, 0
	} else if string(strconv.Itoa(s1)[1]) == string(strconv.Itoa(s2)[1]){
		return 1,1
	}
	return -1, -1
}

func getCancelledVal(i int, j int, iIndex int, jIndex int) float32{
	var newI, newJ int64
	if iIndex == 0 {
		newI, _ = strconv.ParseInt(string(strconv.Itoa(i))[1:], 0, 64)
	} else {
		newI, _ = strconv.ParseInt(string(strconv.Itoa(i))[:1], 0, 64)
	}
	if jIndex == 0 {
		newJ, _ = strconv.ParseInt(string(strconv.Itoa(j))[1:], 0, 64)
	} else {
		newJ, _ = strconv.ParseInt(string(strconv.Itoa(j))[:1], 0, 64)
	}
	if newJ == 0{
		return -1
	}
	return float32(newI)/float32(newJ)
}

func printSlice(s []int) {
	fmt.Printf("len=%d cap=%d %v\n", len(s), cap(s), s)
}
