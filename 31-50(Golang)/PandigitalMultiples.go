package main

import (
	"fmt"
	"strings"
	"regexp"
	"strconv"
)

func main(){
	upperLim:= 99999
	largestPandigital:= 0
	number:= 0
	correspondingN:= 0

	for i:=1; i<upperLim; i++{
		val := -1
		n := 1
		concatedProduct := -1
		for {
			if concatedProduct > 987654321 {
				break
			}
			n++
			concatedProduct = getConcatedProduct(i, n)
			if isOneToNinePandigital(strconv.Itoa(concatedProduct)){
				val = concatedProduct
			}
		}
		if val > largestPandigital {
			largestPandigital = val
			number = i
			correspondingN = n -1
		}
	}

	fmt.Println(largestPandigital, "created by", number, "with n:", correspondingN)
}

func getConcatedProduct(number int, n int) int{
	var returnVal string
	returnVal= ""
	for j:=1; j<=n; j++{
		returnVal += strconv.Itoa(number*j)
	}
	returnValInt, _ := strconv.ParseInt(returnVal, 0, 64)
	return int(returnValInt)
}

func isOneToNinePandigital(word string) bool{
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
