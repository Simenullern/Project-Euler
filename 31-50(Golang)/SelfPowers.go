package main

import ("math/big"
	"fmt"
)

func main(){
	var bigNum big.Int
	bigNum.SetUint64(1)

	var i int64
	for i=2; i<=1000; i++{
		bigi := new(big.Int).Exp(big.NewInt(i), big.NewInt(i), nil)
		bigNum.Add(&bigNum, bigi)
	}
	bigStr := bigNum.String()
	last10  := bigStr[len(bigStr)-10:]
	fmt.Println(last10)
}
