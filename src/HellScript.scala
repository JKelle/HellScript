class HellScript {

    var vars:Map[Symbol,Int] = Map()

    def print(str:String) {
        println(str);
    }

    def print(sym:Symbol) {
        println(vars(sym));
    }

    def SET(sym:Symbol, value:Int) {
        vars += sym -> value;
    }

}
