package main

import (
	"math"
	"strconv"
	"mathutil"
	"fmt"
	"sort"
)

func main(){
	primes := getPrimesBetween(1000, 9999) // set working as map[int]bool
	for k,_ := range primes{
		perms := getPermutations(k, primes)
		series := sliceSubsetArithmeticSeriesOf3(perms)
		if series!= nil && series[0]!=1487{
			fmt.Println(series)
			break
		}
	}
}

func sliceSubsetArithmeticSeriesOf3(slice []int) []int{
	differences := make(map[int][]int) // number as key and count as first value in slice, then indexes from the slice where the differences are
	for i:=0; i<len(slice)-1; i++{
		for j:=0; j<len(slice); j++{
			if j>i{
				var diff int
				if slice[j] > slice[i]{
					diff = slice[j]-slice[i]
				} else {
					diff = slice[i]-slice[j]
				}
				_, ok := differences[diff]
				if ok {
					differences[diff][0]++
				} else {
					differences[diff] = []int{1}
				}
				differences[diff] = append(differences[diff], slice[i]) // get index where we found difference
				if differences[diff][0] == 2{ // might be arithmetic series, but might also be a lucky set of differences
					series := []int{differences[diff][1],differences[diff][2], slice[j]}
					sort.Ints(series)
					if isArithmeticSeries(series){
						return series
					}

				}
			}
		}
	}
	return nil
}


func isArithmeticSeries(slice []int) bool{
	diff := slice[1]-slice[0]
	for i:=2; i<len(slice); i++{
		if slice[i]-slice[i-1] != diff{
			return false
		}
	}
	return true
}

func getPermutations(pr int, primesMap map[int]bool) []int{
	out := []int{}
	var prime = vals{intToSlice(pr)}

	mathutil.PermutationFirst(prime)
	perm := sliceToInt(prime.nums)
	if primesMap[perm] == true{
		out = append(out, perm)
	}
	for mathutil.PermutationNext(prime){
		perm := sliceToInt(prime.nums)
		if primesMap[perm] == true{
			out = append(out, perm)
		}
	}
	return out
}

func getPrimesBetween(lower, upper int) map[int]bool{
	primes := make(map[int]bool)
	for num:=lower; num<=upper; num++{
		if isPrime(num){
			primes[num] = true
		}
	}
	return primes
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

func intToSlice(n int)[]int{
	out := []int{}
	str := strconv.Itoa(n)
	for _,v := range str{
		num, _ := strconv.ParseInt(string(v), 10, 64)
		out = append(out, int(num))
	}
	return out
}

func sliceToInt(slice []int)int{
	var outStr string
	for _, v := range slice{
		outStr += strconv.Itoa(v)
	}
	out,_ := strconv.ParseInt(outStr, 10, 64)
	return int(out)
}
