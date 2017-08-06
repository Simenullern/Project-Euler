package main

import "fmt"

func main(){
	numbers := []int{}
	for i:=1; i<=100000; i++{// some arbitary big number
		numbers = append(numbers, triangular(i))
		numbers = append(numbers, pentagonal(i))
		numbers = append(numbers, hexagonal(i))
	}
	result:= getTripleDuplicates(numbers)
	fmt.Println(result)
}

func triangular (n int) int{
	// Tn=n(n+1)/2
	return n*(n+1)/2
}

func pentagonal(n int) int{
	// Pn=n(3n−1)/2
	return n*(3*n-1)/2
}

func hexagonal(n int) int{
	// Hn=n(2n−1)
	return n*(2*n-1)
}

func getTripleDuplicates(elements []int) []int {
	// Use map to record number of occurences as we find them.
	encountered := map[int]int{}
	result := []int{}

	for v := range elements {
		if encountered[elements[v]] == 2 {
			result = append(result, elements[v])
		} else {
			encountered[elements[v]]++
		}
	}
	return result
}
