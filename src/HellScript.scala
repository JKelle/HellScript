import scala.language.implicitConversions
class HellScript {
    
    var ints:Map[Symbol,Int] = Map()
    var strings:Map[Symbol, String] = Map()
    var condition:Boolean = false;
    var funcs:Map[Symbol, Unit] = Map()
    
    def Print(value:Int) {
        print(value)
    }
    
    def Print(str:String) {
        print(str);
    }

    def Print(sym:Symbol) {
        if(strings contains sym)
            print(strings(sym));
        else if(ints contains sym)
            print(ints(sym))
    }
    
    def Println(value:Int) {
        println(value)
    }
    
    def Println(str:String) {
        println(str);
    }

    def Println(sym:Symbol) {
        if(strings contains sym)
            println(strings(sym));
        else if(ints contains sym)
            println(ints(sym))
    }
    
    def run(body: => Unit) {
        body
    }

    def If(pred:Boolean)(body: => Unit) {
        if (pred) {
            body
            condition = true
        }
    }
    
    def Elseif(pred:Boolean)(body: => Unit) {
        if (pred & !condition) {
            body
            condition = true
        }
    }
    
    def Else(body: => Unit) {
        if (!condition)
          body
        
        condition = false
    }

    def Def(funcname: Symbol)(body : => Unit)(body2 : => Unit) {  
        println("in def") 
        println(body) 
        println(body2) 

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
	          return ints(sym)
	      return 0
    }
    
    def GetString(sym:Symbol) : String = {
        if(strings contains sym)
	          return strings(sym)
	      return ""
    }

    def temp(sym:Symbol) {
        println(sym)
        println(funcs contains sym)
        println(funcs(sym));
    }
    
    case class startswithsym(sym:Symbol){
        def apply() = temp(sym)


        /*if( funcs contains sym) {
           
            //var temp = ints;
            //ints += //get the param
            funcs(sym)
            print("here")
            //ints = temp
        }
        else if( ints contains sym) {
            ints(sym);
            //do something
        }
        else if( strings contains sym ) {
            strings(sym);
            //do something
        } */  
    }
    implicit def sym(symbol:Symbol) = startswithsym(symbol)
    
    
}