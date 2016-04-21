object HelloWorld extends HellScript{
    def main(args: Array[String]): Unit = {
    	Print("helloworld");
    	If(1<2) { 
    		Print("asdf")
    		If(5>3){
    			Print("asdf2")
    		}
    	}
    }
}
