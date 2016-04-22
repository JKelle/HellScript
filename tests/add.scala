
object Add extends HellScript{
    def main(args: Array[String]): Unit = {
        Set('x, 5)
        Println('x)
        Set('x, (GetInt('x) + 1))
        Println('x)
        Set('y, "a string")
        Println('y)
        
        // Original syntax:
//        var x:Int = 5
//        print(x)
//        x = x - 1
//        print(x)
    }
}