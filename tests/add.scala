
object Add extends HellScript{
    def main(args: Array[String]): Unit = {
        'x := 5
        Println('x)
        'x := 'x + 1
        Println('x)
        'y := "a string"
        Println('y)

        // Original syntax:
//        var x:Int = 5
//        print(x)
//        x = x - 1
//        print(x)
    }
}