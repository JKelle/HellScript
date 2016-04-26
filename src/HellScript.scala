import scala.language.implicitConversions
class HellScript {
    
    var ints:Map[Symbol,Int] = Map()
    var strings:Map[Symbol, String] = Map()
    var condition:Boolean = false
    var funcs:Map[Symbol, () => Unit] = Map()

    case class Assign(v: Symbol){
        def :=(value:Int)= Set(v,value)
        def :=(value:String)= Set(v,value)
    }
    case class LogicOp(lhs: Boolean){
        def or(rhs:Boolean)= lhs || rhs
        def and(rhs:Boolean)= lhs && rhs
    }
  
  
  
    def not(value: Boolean): Boolean = {
      !value
    }
  
    implicit def inttobool(i: Int):Boolean = if(i==0) false else true
    //implicit def vartostr(s:Symbol) = GetString(s)
    implicit def vartoint(s:Symbol) = GetInt(s)
    implicit def varname(sym: Symbol) = Assign(sym)
    implicit def logic(b:Boolean) = LogicOp(b)
    implicit def logic(i:Int) = LogicOp(i)
    
    def Print(value:Int) {
        print(value)
    }
    
    def Print(str:String) {
        print(str)
    }

    def Print(sym:Symbol) {
        if(strings contains sym)
            print(strings(sym))
        else if(ints contains sym)
            print(ints(sym))
    }
    
    def Println(value:Int) {
        println(value)
    }
    
    def Println(str:String) {
        println(str)
    }

    def Println(sym:Symbol) {
        if(strings contains sym)
            println(strings(sym))
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
    
    def ElseIf(pred:Boolean)(body: => Unit) {
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
    

/*    def Def(funcname: Symbol)(body : => Unit) {  
        funcs += funcname -> body;
        println("in def") 
        println(body) 
    }*/

    def Def(funcname: Symbol)(arg1:Any)(body : () => Unit) {
        funcs += funcname -> body
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
	      else 0
    }
    
    def GetString(sym:Symbol) : String = {
        if(strings contains sym)
	          strings(sym)
	      else ""
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
          }*/
    }
    implicit def funccall(symbol:Symbol) = funcs(symbol)
    
}
