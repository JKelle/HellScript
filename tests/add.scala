
object Add extends HellScript{
    def main(args: Array[String]): Unit = {
        set('x, 5)
        print('x)
        set('x, (getInt('x) + 1))
        print('x)
        set('y, "hello")
        print('y)
        
        // Original syntax:
//        var x:Int = 5
//        print(x)
//        x = x - 1
//        print(x)
    }
}