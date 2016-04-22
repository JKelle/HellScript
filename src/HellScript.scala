class HellScript {
    
    var ints:Map[Symbol,Int] = Map()
    var strings:Map[Symbol, String] = Map()
    var funcs:Map[Symbol, Unit] = Map()
    
    def Print(value:Int) {
        println(value)
    }
    
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

    def Def(funcname: Symbol)(body : => Unit) {
        funcs += funcname -> body;
    }

    def set(sym:Symbol, value:Any) {
        // To use when we're ready to make things hell-ish
//        if (sym.name.charAt(0) != 't')        
//          throw new Exception("You fool! Variables must begin with 't'");
        
        value match {
          case value:Int => ints += sym -> value
          case value:String => strings += sym -> value
        }
    }
    
    def getInt(sym:Symbol) : Int = {
        if(ints contains sym)
	          ints(sym)
	      0
    }
    
    def getString(sym:Symbol) : String = {
        if(strings contains sym)
	          strings(sym)
	      ""
    }
    
    abstract sealed class HellScriptClass
    case class startswithsym(sym:Symbol) extends HellScriptClass {
        if( funcs contains sym) {
            funcs(sym)
        }
        else if( ints contains sym) {
            //do something
        }
        else if( strings contains sym ) {
            //do something
        }
    }
    implicit def sym(symbol:Symbol) = startswithsym(symbol)
    
//    abstract sealed class HellScriptClass
//    case class setVar(sym:Symbol) extends HellScriptClass{
//        object PRINT {
//            def apply(str:String) = set(sym, str);
//            def apply(v:Int) = set(sym,v);
//        }
//        
//        def set(sym:Symbol, v:Int) {
//            ints += sym -> v
//        }
//        
//        def set(sym:Symbol, v:String) {
//            strings += sym -> v
//        }
//    }
//    implicit def setVars(sym:Symbol) = setVar(sym)
    
}
