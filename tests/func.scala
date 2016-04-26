
object Func extends HellScript {

  	def factorial(n:Int) : Int = {
  		If(n == 1) {
  			return 1
  		}
  		return n*factorial(n-1)
  	}

  	def area(w:Int, h:Int) : Int = {
  		'a := w*h
  		return 'a
  	}

    def main(args: Array[String]): Unit = {

    		Println(factorial(5))
    		Println(area(21,3))

    }
}