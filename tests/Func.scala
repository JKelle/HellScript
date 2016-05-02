object Func extends HellScript {
    def main(args: Array[String]): Unit = {
        Def noarg() = {
            Print("No args!")
        }

        Def onearg('tx) = {
            Print('ty)
        }

        'noarg()
        'onearg(8)
    }
}