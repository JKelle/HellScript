
object HelloWorld extends HellScript{
    def main(args: Array[String]): Unit = {

        var x:int = 1
        var y:int = 5

        if (x > y) {
            print("x")
        }
        else if (y > x) {
            print("y")
        }
        else {
            print("xy")
        }

    }
}
