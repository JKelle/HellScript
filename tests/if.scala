object If extends HellScript {
    def main(args: Array[String]): Unit = {

        Set('x, 1)
        Set('y, 5)
        
        If(GetInt('x) > GetInt('y)) {
            Print("x")
        }
        Elseif (GetInt('y) > GetInt('x)) {
            Print("y")
        }
        Else {
            Print("z")
        }
        
        // Original syntax:
//        var x:int = 1
//        var y:int = 5
//
//        if (x > y) {
//            print("x")
//        }
//        else if (y > x) {
//            print("y")
//        }
//        else {
//            print("xy")
//        }

    }
}