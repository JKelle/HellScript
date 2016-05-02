object Func extends HellScript {
    def main(args: Array[String]): Unit = {
        Def noarg() = {
            Print("No args!")
        }

        Def onearg('thishasonearg) = {
            Print('thishasonarg)
        }

        noarg()
        'tx := 5
        'tx := 'tx + 1
        onearg('tx)
    }
}