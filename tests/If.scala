object If extends HellScript {
    def main(args: Array[String]): Unit = {
        // Start here
        'x := 1
        'y := 3

        If('x < 'y) {
            Print("x")
        }
        Elseif('x > 'y) {
            Print("y")
        }
        Else {
            Print("z")
        }
    }
}