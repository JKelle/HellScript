object If extends HellScript {
    def main(args: Array[String]): Unit = {
        'x := 1
        'y := 5
        
        If('x > 'y) {
            Println("x")
        }
        ElseIf('y > 'x) {
            Println("y")
        }
        Else {
            Println("z")
        }
    }
}