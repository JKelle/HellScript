class HellScript {
    
    var ints:Map[Symbol,Int] = Map()
    var strings:Map[Symbol, String] = Map()
    
    def print(str:String) {
	      println(str);
    }

    def print(sym:Symbol) {
	      if(strings contains sym)
	           println(strings(sym));
	      else if(ints contains sym)
	           println(ints(sym))
    }
   
    def set(sym:Symbol, value:Int) {
        ints += sym -> value
        
        // To use when we're ready to make things hell-ish
//        if (sym.name.charAt(0) == 't') {
//          vars += sym -> value
//        } else {
//          throw new Exception("Variables must begin with 't'");
//        }
    }
    
    def set(sym:Symbol, value:String) {
        strings += sym -> value
    }
    
    // TODO: Basically returns nothing
    def get(sym:Symbol) {
        if(strings contains sym)
	           return strings(sym)
	      else if(ints contains sym)
	           return ints(sym)
    }
    
    
    abstract sealed class HellScriptClass
    case class setVar(sym:Symbol) extends HellScriptClass{
        object PRINT {
            def apply(str:String) = set(sym, str);
            def apply(v:Int) = set(sym,v);
        }
        
        def set(sym:Symbol, v:Int) {
            ints += sym -> v
        }
        
        def set(sym:Symbol, v:String) {
            strings += sym -> v
        }
    }
    implicit def setVars(sym:Symbol) = setVar(sym)
}