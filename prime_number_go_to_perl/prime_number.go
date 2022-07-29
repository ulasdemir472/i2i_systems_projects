package main

//command
import (
	"fmt" //print library
	"io"
	"os"
)

func main() {
	//f, err := os.Create("result.txt")
	//check_error(err)
	//num_to_string := strconv.Itoa(num)
	//f.WriteString(num_to_string)
	file, err := os.Open("nums.txt")

	check_error(err)

	var line int
	var results string = ""

	output_file, err := os.Create("result.txt")
	defer output_file.Close()
	check_error(err)

	for {

		_, err := fmt.Fscanf(file, "%d\n", &line)

		if err != nil {
			if err == io.EOF {
				break
			}
			fmt.Println(err)
			os.Exit(1)
		}

		output := fmt.Sprintf("%d%s", line, isPrime(line))
		results = fmt.Sprintf("%s%s", results, output)
		fmt.Print(output)
	}
	dosyaya_yaz := os.WriteFile("result.txt", []byte(results), 0644)
	check_error(dosyaya_yaz)
}

func check_error(err error) {
	if err != nil {
		fmt.Println(err)
		os.Exit(1)
	}
}

func isPrime(num int) string {
	var index bool = true
	if num < 2 {
		return " is not prime number\n"
	}
	for i := 2; i < num; i++ {
		if (num % i) == 0 {
			index = false
		}
	}
	if index {
		return " is prime\n"
	} else {
		return " is not prime\n"
	}
}
