package main

import "fmt"
import "strconv"

func main(){
	lim:=1000000
	sum:=0

	for i:=1; i<lim; i++{
		var baseTen string = strconv.Itoa(i)
		var baseTwo string = strconv.FormatInt(int64(i),2)
		if isPalindromic(baseTen) && isPalindromic(baseTwo){
			sum+=i
		}
	}
	fmt.Println("answ:", sum)
}

func isPalindromic(word string) bool{
	for i:=0; i<len(word); i++{
		if word[i] != word[len(word)-1-i]{
			return false
		}
	}
	return true
}
