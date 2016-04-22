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

/*    def Def(funcname: Symbol)(body : => Unit) {
        funcs += funcname -> body;
    }*/

    def Def(funcname: Symbol)(arg1:Any)(body : => Unit) {
        funcs += funcname -> body;
    }

    def Set(sym:Symbol, value:Any) {
        // To use when we're ready to make things hell-ish
//        if (sym.name.charAt(0) != 't')        
//          throw new Exception("You fool! Variables must begin with 't'");
        
        value match {
          case value:Int => ints += sym -> value
          case value:String => strings += sym -> value
        }
    }
    
    def GetInt(sym:Symbol) : Int = {
        if(ints contains sym)
	          ints(sym)
	      0
    }
    
    def GetString(sym:Symbol) : String = {
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
            ints(sym);
            //do something
        }
        else if( strings contains sym ) {
            strings(sym);
            //do something
        }
    }
    implicit def sym(symbol:Symbol) = startswithsym(symbol)
    
    
}
