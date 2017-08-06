package main

import (
	"math"
	"fmt"
)
/*
legg sammen alle tall fra og med 2 til og med opp til 1 million (?) eller en eller annen safe øvre limit.
trekk fra de største primtallene mindre enn upper limit helt til du får et primtall
repeat fra og med 3.. 5...
 */

func main(){
	primes := getPrimesLessThan(50000) // 50 000 is probably a safe upper limit
	var score, maxTerms int
	for i:=0; i<len(primes); i++{
		sum:=0
		for j:=i; j<len(primes); j++{
			sum += primes[j]
			if sum > 1000000{
				terms := getTerms(j, i, maxTerms, sum, primes)
				if terms != nil {
					maxTerms = terms[0]
					score = terms[1]
					fmt.Println("new highscore with", maxTerms, "terms, starting from", primes[i], "sigma", primes[i+maxTerms], "reaching", score)
				}
				break
			}
		}
	}
	fmt.Println("answer is", score, "containing", maxTerms, "terms")
}

func getTerms(j, i, maxTerms, sum int, primes[]int) []int{
	incrementer := 0
	for j > incrementer{
		sum -= primes[j-incrementer]
		noOfTerms:= j-i-incrementer // j er dit vi har kommet, i er der vi startet, dowcounter er antall ganger vi har trukket fra
		if isPrime(sum) && noOfTerms > maxTerms{
			return []int{noOfTerms, sum}
		}
		incrementer++
	}
	return nil
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
