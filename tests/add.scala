object Add extends HellScript{
    def main(args: Array[String]): Unit = {
        'x := 5
        Println('x)
        'x := 'x + 1
        Println('x)
        'y := "a string"
        Println('y)
    }
}