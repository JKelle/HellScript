import scala.language.implicitConversions
import scala.language.dynamics
class HellScript {
    
    var ints:Map[Symbol,Int] = Map()
    var strings:Map[Symbol, String] = Map()
    var condition:Boolean = false
    var funcs:Map[Symbol, (Symbol, Function)] = Map()
    var vowels:Array[Char] = Array('a', 'e', 'i', 'o', 'u')

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
    
    def If(pred:Boolean)(body: => Unit) {
        if (pred) {
            body
            condition = true
        } else {
            condition = false
        }
    }
    
    def ElseIf(pred:Boolean)(body: => Unit) {
        if (pred & !condition) {
            body
            condition = true
        } else {
            condition = false
        }
    }
    
    def Else(body: => Unit) {
        if (!condition)
          body
        
        condition = false
    }

    //Define a function with zero parameters
    def MyDef0(funcname: Symbol)(body: => Any) = {
        funcs += funcname -> ('null, new Function(body))
    }

    //Define a function with one parameter
    def MyDef1(funcname: Symbol)(arg1:Symbol)(body: => Any) = {
        //val body = new Function(Println("HI"))
        funcs += funcname -> (arg1, new Function(body))
    }

    object Def extends Dynamic {
        def applyDynamic(name: String)(arg: Symbol) = {
            //Def(Symbol(name))(arg)
            //Symbol(name) === 'printhi
            //println(s"Def $name($arg)")
        }
        def selectDynamic(name: String) = new {
            def update(body: => Unit) = {
                MyDef0(Symbol(name))(body)
            }
            def update(arg: Symbol, body: => Unit) = {
                MyDef1(Symbol(name))(arg)(body)
            }
        }
        //MyDef printhi ('x) ~~ MyDef.applyDynamic("printhi")('x)
    }

    class Function(body: => Unit) {
        def call = body
    } 

    def Set(sym:Symbol, value:Any) {
        // To use when we're ready to make things hell-ish
//        if (sym.name.charAt(0) != 't')
//          throw new Exception("You fool! Variables must begin with 't'!")
//        if (sym.name.length() > 5)        
//          throw new Exception("You fool! The max length of anything is 5!")
        
        
        value match {
          case value:Int => SetInt(sym, value)
          case value:String => SetString(sym, value)
        }
    }
    
    def SetInt(sym:Symbol, value:Int) {
//        var stringValue = value.toString()
//        
//        if (stringValue.length() > 5)
//          throw new Exception("You fool! The max length of anything is 5!")
//        
//        for (i <- 0 until stringValue.length()) {
//            if (vowels.contains(stringValue.charAt(i)))
//                throw new Exception("You fool! No vowels allowed!")
//        }
        
        ints += sym -> value
    }
    
    def SetString(sym:Symbol, value:String) {
//        if (value.length() > 5)
//          throw new Exception("You fool! The max length of anything is 5!");
//        
//        for (i <- 0 until value.length()) {
//            if (vowels.contains(value.charAt(i)))
//                throw new Exception("You fool! No vowels allowed!")
//        }
        
        strings += sym -> value
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
    
    def exec(sym:Symbol) {
        val ints2 = ints
        val strings2 = strings

        funcs(sym)._2.call

        ints = ints2
        strings = strings2
    }
    
    def exec(sym:Symbol, arg:Any) {

        val ints2 = ints
        val strings2 = strings

        val tup = funcs(sym)

        arg match {
          case arg:Int => ints += tup._1 -> arg // add func arg to list
          case arg:String => strings += tup._1 -> arg // add func arg to list
        }

        tup._2.call

        ints = ints2
        strings = strings2
    }

    case class startswithsym(sym:Symbol){
        def apply() = exec(sym)
        // def apply(arg:Int) = exec(sym, arg)
        // def apply(arg:String) = exec(sym, arg)
        // def apply(arg:Symbol) = exec(sym, arg)
        def apply(arg:Any) = exec(sym, arg)
        def apply(arg:Any, arg2:Any) = exec(sym)


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
    implicit def funccall(name:Symbol) = startswithsym(name)
    
}