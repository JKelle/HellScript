class HellScript {
    
    var vars:Map[Symbol,Int] = Map()
    
    def print(str:String) {
	      println(str);
    }

    def print(sym:Symbol) {
	      println(vars(sym));
    }
   
    def SET(sym:Symbol, value:Int) {
        vars += sym -> value
        
        // To use when we're ready to make things hell-ish
//        if (sym.name.charAt(0) == 't') {
//          vars += sym -> value
//        } else {
//          throw new Exception("Variables must begin with 't'");
//        }
    }
    
}