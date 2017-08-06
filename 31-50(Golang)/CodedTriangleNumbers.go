package main

import ("fmt"
	"io/ioutil"
	"strings")

func main(){
	triangleNumbers := getTriangleNumbers() //simplified set structure
	wordsSlice := getWordsFromFile("p042_words.txt")
	alphabetDigits:= getAlphabetDigits()
	count:= 0

	for _, element := range wordsSlice{
		numericVal := 0
		element = element[1 : len(element)-1] // remove quotation marks
		for _,char := range element{
			numericVal += alphabetDigits[string(char)]
		}
		if triangleNumbers[numericVal] == true {
			count++
		}
	}

	fmt.Println("answ:", count)

}

func getTriangleNumbers() map[int]bool {
	triangleNumbers:= map[int]bool{}
	incrementer:= 1
	for i:=1; i < 10000; i+=incrementer{
		triangleNumbers[i] = true
		incrementer++
	}
	return triangleNumbers
}

func getAlphabetDigits() map[string]int{
	out:= map[string]int{}
	for pos, char := range "ABCDEFGHIJKLMNOPQRSTUVWXYZ" {
		out[string(char)] = pos+1
	}
	return out
}

func getWordsFromFile(filename string) []string{
	words, err := ioutil.ReadFile(filename)
	check(err)
	return strings.Split(string(words), ",")
}


func check(e error) {
	if e != nil {
		panic(e)
	}
}
