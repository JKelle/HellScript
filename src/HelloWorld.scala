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

    'z := "asdf"
    'z := 'd
    Println('x)
    Println('x)
    Println('x)

    Def printhi('x) = {
    	Println('x)
    }

    Def whatsup() = {
    	Println("not much")
    }

    //this.printhi()
    //'printhi (59)

    }
}
