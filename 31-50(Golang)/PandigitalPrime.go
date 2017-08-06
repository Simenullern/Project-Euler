package main

import ("fmt"
	"math"
	"mathutil"
	"strconv"
)

type vals struct{
	nums []int
}

func (v vals) Len() int{
	return len(v.nums)
}

func (v vals) Less(i,j int) bool{
	return v.nums[i] > v.nums[j]
}

func (v vals) Swap(i,j int){
	temp1:=v.nums[i]
	temp2:=v.nums[j]
	v.nums[i] = temp2
	v.nums[j] = temp1
}

func main(){
	var arr = vals{[]int{1, 2, 3, 4, 5, 6, 7, 8, 9}}
	mathutil.PermutationFirst(arr)
	var num int
	dcounter:= 9

	for {
		old := num
		num = valstoint(arr)

		if num == old {
			// go with one digit less
			arr = getVals(dcounter)
			dcounter--
			mathutil.PermutationFirst(arr)
		}
		if isPrimed(num){
			fmt.Println("answ", num)
			break
		} else {
			mathutil.PermutationNext(arr)
		}
	}

}

func getVals (dcounter int) vals{
	var slice[]int

	for j:=1; j<dcounter; j++{
		slice = append(slice, j)
	}
	return vals{slice}
}

func valstoint (v vals) int{
	var out string
	for _, element := range v.nums {
		out += strconv.Itoa(element)
	}
	result,_ := strconv.ParseInt(out, 10, 64)
	return int(result)
}

func isPrimed(val int) bool {
	if val < 2 {
		return false
	}
	for i := 2; i <= int(math.Floor(math.Sqrt(float64(val)))); i++ {
		if val%i == 0 {
			return false
		}
	}
	return true
}


