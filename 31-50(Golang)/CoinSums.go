package main

import "fmt"

func main() {
	//bruteForced()
	dynamicProg()
}

func dynamicProg(){
	goal:= 200;
	coins := [8]int{1, 2, 5, 10, 20, 50, 100, 200}
	var possibilites [201]int
	possibilites[0] = 1

	for coin:= 0; coin < len(coins); coin++{
		for value:=coins[coin]; value <= goal; value++{
			possibilites[value] += possibilites[value-coins[coin]]
		}
	}
	fmt.Println(possibilites[len(possibilites)-1])
}

func bruteForced(){
	counter:= 0
	for one:=0 ; one <= 200; one++{
		for two:=0 ; two <= 200; two+=2{
			for five:=0 ; five <= 200; five+=5{
				for ten:=0 ; ten <= 200; ten+=10{
					for twenty:=0 ; twenty <= 200; twenty+=20{
						for fifty:=0 ; fifty <= 200; fifty+=50{
							for hundred:=0 ; hundred <= 200; hundred+=100{
								for twoHundred:=0 ; twoHundred <= 200; twoHundred+=200{
									if one+two+five+ten+twenty+fifty+hundred+twoHundred == 200{
										counter++
									}
								}

							}

						}

					}

				}
			}
		}
	}
	fmt.Println("answ: ", counter)
}