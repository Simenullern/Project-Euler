package main

import "fmt"
import "math"

func main(){
	lim:=1000
	maxSolutions:= -1
	finalP:= -1

	for p:=1; p<=lim; p++ {
		solutions := 0;
		for k1:=1; k1 < int(math.Floor(float64(p/2))); k1++ {
			for k2:=1; k2 < int(math.Floor(float64(p/2))); k2++{
				hyp := math.Sqrt(float64(k1*k1 + k2*k2))
				if float64(k1) + float64(k2) + hyp == float64(p) {
					solutions++
				}
				if float64(k1)+float64(k2)+(hyp) > float64(p) { // no point to iterate further in outer loop
					break
				}
			}
		}
		if solutions/2 > maxSolutions {
			maxSolutions = solutions/2
			finalP = p
		}
	}

	fmt.Println("p:", finalP, "has", maxSolutions, "solutions")


}
