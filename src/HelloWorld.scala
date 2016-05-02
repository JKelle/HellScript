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

    'tmp := 3+4+5+6+1
    'tsdf := 'tmp
    Println('tasdf)

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
