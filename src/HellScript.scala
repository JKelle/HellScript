class HellScript {

    var linenum = 0;
    var lines:Map[Symbol, String] = Map()

    var ints:Map[Symbol,Int] = Map()
    var strings:Map[Symbol, String] = Map()

    def Print(str:String) {
        println(str);
    }

    def Print(sym:Symbol) {
        if(strings contains sym)
            println(strings(sym));
        else if(ints contains sym)
            println(ints(sym))
    }
    
    def If(pred:Boolean)(body: => Unit) {
        if (pred) {
            body
        }
    } 

    abstract sealed class HellScriptClass
    case class varCase(sym:Symbol) extends HellScriptClass{
        object PRINT {
            def apply(str:String) = set(sym, str);
            def apply(v:Int) = set(sym,v);
        }

        def set(sym:Symbol, v:Int) {
            ints += sym -> v
        // To use when we're ready to make things hell-ish
//        if (sym.name.charAt(0) == 't') {
//          vars += sym -> value
//        } else {
//          throw new Exception("Variables must begin with 't'");
//        }
        }

        def set(sym:Symbol, v:String) {
            strings += sym -> v
        // To use when we're ready to make things hell-ish
//        if (sym.name.charAt(0) == 't') {
//          vars += sym -> value
//        } else {
//          throw new Exception("Variables must begin with 't'");
//        }            
        }
    }
    implicit def vars(sym:Symbol) = varCase(sym)
}
