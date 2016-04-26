object HelloWorld extends HellScript{
    def main(args: Array[String]): Unit = {

      Println("helloworld")

      If(((1 or 0) and 5) or not(true)) {
        'x := 20 * 5 + 5 * 12
        't := 'x + 5
        'y := "bees"
        Println('x)
        Println('t)
        Println('y)
      }

      //need some way to convert expressions into anon functions
      // need to clarify syntax for functions
    	Def ('printhi)() {
        () => Println("HI")
      }

    'printhi ()
    'printhi ()

    }
}
