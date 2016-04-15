
def factorial(n:int):int {
	if(n == 1) {
		return 1
	}
	return n*factorial(n-1)
}

def area(w:int, h:int):int {
	var a:int = w*h
	return a
}

print(factorial(5))
print(area(21,3))
