package main

import (
	"math"
	"fmt"
)

func main(){
	for i:=2; i<math.MaxInt64; i++{
		if isPrime(i) || i%2==0 {
			continue
		} else { // odd composite number
			if !isWrittenAsPrimeAndSquare(i){
				fmt.Println("answ", i)
				return
			}
		}
	}
}

func isWrittenAsPrimeAndSquare(num int) bool{
	// brute force every possibility. Straight forward
	primes := getPrimesLessThan(num) // this could be highly optimized if wanted by cach
	for _, v:= range primes{
		for sq:=1; sq<num; sq++{
			if v+(2*sq*sq) == num {
				return true
			}
			if v+(2*sq*sq) > num{
				break
			}
		}
	}
	return false
}

func getPrimesLessThan(num int) []int{
	result:=[]int{}
	for j:=2; j<num; j++{
		if isPrime(j){
			result = append(result, j)
		}
	}
	return result
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


