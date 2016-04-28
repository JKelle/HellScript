object HelloWorld extends HellScript{
    def main(args: Array[String]): Unit = {

      Println("helloworld")

      //need some way to convert expressions into anon functions
      // need to clarify syntax for functions
/*    Def ('printhi)('x) {
    	Println('x)
    	Println("HI")
		Println("HI2")
      }*/

/*    MyDef printhi ('x) =  {
    	Println('x)
    }*/

    'tz := 3
    'tz := 5
    'tz := 'tx
    Println('tz)
    
    'tx := 3
//    While('tx > 1) {
//    	Println("x is greater than 2!")
//    	'tx := 'tx - 2
//    }

    Def printhi('tx) = {
    	Println('tx)
    }

    Def whatsup() = {
    	Println("not much")
    }

    //this.printhi()
    //'printhi (59)

    }
}
