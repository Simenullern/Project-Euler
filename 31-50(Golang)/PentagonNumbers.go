package main

import (
	"fmt"
	"math"
)

func main(){
	pentagons := make(map[int]int) //pentagon value as key and its number as val
	for i:=2; i<10000; i++{
		pentagons[getPentagonNum(i)] = i
	}
	//brute
	min:=9999999999999999

	for k1 := range pentagons{
		for k2 := range pentagons{
			if pentagons[k1+k2] != 0{
				d := int(math.Abs(float64(k1-k2)))
				if pentagons[d] != 0 {
					if d < min {
						min = d
						fmt.Println("new min", min, "for", k1, "and", k2, "that is numbers", pentagons[k1], "and", pentagons[k2])

					}
				}
			}
		}
	}
}

func getPentagonNum(n int) int{
	return n*((3*n)-1)/2
}

