object Func extends HellScript {
    def main(args: Array[String]): Unit = {
        Def noarg() = {
            Print("N0 @rgs!")
        }
        
        Def onearg('tx) = {
            Print('ty)
        }
        
        'noarg()
        'onearg(1)
    }
}