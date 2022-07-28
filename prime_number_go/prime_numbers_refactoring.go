package main

//command
import (
	"fmt" //print library
	"io"
	"os"
)

func main() {
	read_file_take_number()

}

func read_file_take_number() {
	file, err := os.Open("nums.txt")

	if err != nil {
		fmt.Println(err)
		os.Exit(1)
	}

	var line int

	for {

		_, err := fmt.Fscanf(file, "%d\n", &line)

		if err != nil {
			if err == io.EOF {
				break
			}
			fmt.Println(err)
			os.Exit(1)
		}

		isPrime(line)
	}
}

func isPrime(num int) {
	var index bool = true
	if num < 2 {
		fmt.Printf("%d is not prime number\n", num)
		return
	}
	for i := 2; i < num; i++ {
		if (num % i) == 0 {
			index = false
		}
	}
	if index {
		fmt.Printf("%d is prime\n", num)
	} else {
		fmt.Printf("%d is not prime\n", num)
	}
}
