package main

import ("fmt"
	"strconv"
	"time")

func main() {
	lim := 1000000
	t := time.Now()
	product := 1
	currentNumSize := 1
	mod := 10
	nextFract := 10
	noOfDigits := 0

	for i:=1; i<=lim; i++{
		if i%mod == 0 { // øker sifferstørrelsen
			currentNumSize++
			mod *= 10
		}
		noOfDigits += currentNumSize
		if noOfDigits>=nextFract { // vi må hente verdien som gjorde digits > nextFract
			temp := noOfDigits
			count := 1
			for {
				if temp-count < nextFract{
					istr := strconv.Itoa(i)
					mult,_ := strconv.ParseInt(string(istr[len(istr)-count]), 0, 64)
					product *= int(mult)
					break
				} else {
					count++
				}
			}
			nextFract *= 10
		}
	}
	fmt.Println("answ in", time.Since(t), "is", product)
}