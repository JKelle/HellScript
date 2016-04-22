object HelloWorld extends HellScript{
    def main(args: Array[String]): Unit = {
    	Print("helloworld");
    	Set('x, 4)
    	Set('y, 6)

    	If(GetInt('x) < GetInt('y)) { 
    		Print("asdf")
    		If(5>3){
    			Print("asdf2")
    		}
    	}

    	Def ('printhi) ('x) {
    		Print('x)
    		Print("HI")
    	}

    	'printhi 

    }
}
