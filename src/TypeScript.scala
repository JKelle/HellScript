

class TypeScript {
    
    var vars:Map[Symbol,Int] = Map()
  
    abstract sealed class TypeScriptClass
    case class PrintString(num: Int, s: String) extends TypeScriptClass
    
     /**
     * LineBuilder is the jump off point for the line number syntax of
     * BASIC expressions.  Simply put, the `int2LineBuilder` implict
     * puts an instance of this class in place when it finds an Int
     * followed by one of the provided methods.  That is, this *only* handles
     * the forms that follow a line number and no other forms.  If you need to
     * add new functions that can be put elsewhere, then follow the form
     * used by SQRT and ABS.  For functions that can go *anywhere*, they should
     * be handled here and as separate functions as SQRT.
     */
    case class LineBuilder(num: Int) {

      object PRINT {
        def apply(str:String) = PrintString(str)
        def apply(str:Symbol) = PrintSymbol(str)
      }
      
      object SET {
        def apply(str:Symbol, v:Int) = Set(str, v)
      }
      
      def PrintString(str:String)
      {
        println(str) 
      }
      
      def PrintSymbol(str:Symbol)
      {
        println(vars(str)) 
      }
      
      def Set(str:Symbol, value:Int)
      {
        vars += str -> value;
      }
    }
          
    implicit def int2LineBuilder(i: Int) = LineBuilder(i)
}