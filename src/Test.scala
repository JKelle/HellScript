object Test extends HellScript{
    def main(args: Array[String]): Unit = {

      Print("helloworld")

      Else(((1 or 0) and 5) or not(true)) {
        'x := 20 * 5 + 5 * 12
        't := 'x + 5
        'y := "bees"
        Print('x)
        Print('t)
        Print('y)
      }

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

    Def printhi('x) = {
    	Print('x)
    }

    Def whatsup() = {
    	Print("not much")
    }

    'whatsup()
    'printhi()
    'printhi(23)
    //this.printhi()
    //'printhi (59)

    }
}