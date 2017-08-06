package main

import "fmt"
import "strconv"
import "regexp"
import "strings"

func main(){
	panProducts := make(map[int] bool)

	for multiplicand:=1 ; multiplicand <= 10000; multiplicand++{ // these limits might be reduced with whatever math
		for multiplier:=1; multiplier <= 10000; multiplier++{
			product:= multiplicand * multiplier
			var str string = strconv.Itoa(product)+ strconv.Itoa(multiplicand)+strconv.Itoa(multiplier)
			 if is1to9pandigital(str) && !panProducts[product]{
				panProducts[product] = true
			}
		}
	}
	sum := 0
	for k := range panProducts {
		sum += k
	}
	fmt.Println("answ:", sum)
}

func is1to9pandigital(word string) bool{
	if len(word) != 9 {
		return false
	} else if strings.Contains(word, "0") {
		return false
	}
	for _, char := range word {
		occurence := regexp.MustCompile(string(char))
		matches := occurence.FindAllStringIndex(word, -1)
		if len(matches) != 1 {
			return false
		}
	}
	return true;
}
