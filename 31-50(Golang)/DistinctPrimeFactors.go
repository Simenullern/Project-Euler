package main

import (
	"fmt"
	"math"
)

func main(){
	lastFour := [4][]int{} // keep track of 4 last numbers and their prime factors in each list
	primes := []int{} // all primes less than i as we loop through

	for i:=2; i<math.MaxInt64; i++{
		//fmt.Println(lastFour)
		index := i%4
		if isPrime(i){
			primes = append(primes,i)
			lastFour[index] = []int{} // empty list
		} else {
			primeFactors := []int{}
			for k, v := range getPrimeFactors(i, primes){ // find all prime factors for i
				primeFactors = append(primeFactors, int(math.Pow(float64(k), float64(v))))
			}
			lastFour[index] = primeFactors
			if all16PFs(lastFour) == true {
				fmt.Println("answ", i-3)
				return
			}
		}
	}
}

func all16PFs (numbs [4][]int) bool{
	pfs := make(map[int]bool)
	counter:=0
	for _, list := range numbs{
		for _, num := range list{
			if pfs[num] != true {
				counter++
				pfs[num] = true
			}
		}
	}
	return counter==16
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

func getPrimeFactors(n int, primes []int) map[int]int {
	primeFacts := make(map[int]int) // keeps track of prime factor : exponent pairs
	for n != 1 {
		for i := 0; i < len(primes); i ++ {
			if n % primes[i] == 0 {
				val, ok := primeFacts[primes[i]]
				if !ok {
					val = 0
				}
				primeFacts[primes[i]] = val + 1
				n = n/primes[i]
				break
			}
		}
	}
	return primeFacts
}
