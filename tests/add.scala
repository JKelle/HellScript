
object Add extends HellScript{
    def main(args: Array[String]): Unit = {
        set('x, 5)
        print('x)
        set('y, get('x))
        set('x, ('y + 1))
        print('x)
    }
}