object If extends HellScript {
    def main(args: Array[String]): Unit = {

        set('x, 1)
        set('y, 5)
        
        if (getInt('x) > getInt('y)) {
            print("x")
        }
        else if (getInt('y) > getInt('x)) {
            print("y")
        }
        else {
            print("xy")
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