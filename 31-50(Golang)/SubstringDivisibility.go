package main

import ("fmt"
	"mathutil"
	"strconv"
)

type vals struct{
	nums []int
}

func (v vals) Len() int{
	return len(v.nums)
}

func (v vals) Less(i,j int) bool{
	return v.nums[i] > v.nums[j]
}

func (v vals) Swap(i,j int){
	temp1:=v.nums[i]
	temp2:=v.nums[j]
	v.nums[i] = temp2
	v.nums[j] = temp1
}

func valstoint (arr []int) int{
	var out string
	for _, element := range arr {
		out += strconv.Itoa(element)
	}
	result,_ := strconv.ParseInt(out, 10, 64)
	return int(result)
}

func main(){
	sum:=0
	var arr = vals{[]int{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}}
	mathutil.PermutationFirst(arr)

	for mathutil.PermutationNext(arr){
		if hasDesiredProperty(arr.nums){
			sum += valstoint(arr.nums)
		}
	}
	fmt.Println("answ:", sum)
}

func hasDesiredProperty(arr []int) bool{
	var primes = []int{2, 3, 5, 7, 11, 13, 17}
	currentIndex:= 0
	for i:=1; i<=7; i++{
		num:= arr[i:i+3]
		if valstoint(num)%primes[currentIndex]==0{
			currentIndex++
		} else {
			return false
		}
	}
	return true
}








