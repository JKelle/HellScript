object If extends HellScript {
    def main(args: Array[String]): Unit = {

        'x := 1
        'y := 5

        If('x > 'y) {
            Println("x")
        }
        Elseif ('y > 'x) {
            Println("y")
        }
        Else {
            Println("z")
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