
object Func extends HellScript {

  	def factorial(n:Int) : Int = {
  		if(n == 1) {
  			return 1
  		}
  		return n*factorial(n-1)
  	}
  
  	def area(w:Int, h:Int) : Int = {
  		var a:Int = w*h
  		return a
  	}

    def main(args: Array[String]): Unit = {
    
    		print(factorial(5))
    		print(area(21,3))
    
    }
}