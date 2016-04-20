class HellScript {
    
    var ints:Map[Symbol,Int] = Map()
    var strings:Map[Symbol, String] = Map()
    
    def print(str:String) {
	      println(str)
    }
    
    def print(value:Int) {
        println(value)
    }

    def print(sym:Symbol) {
	      if(strings contains sym)
	           println(strings(sym))
	      else if(ints contains sym)
	           println(ints(sym))
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