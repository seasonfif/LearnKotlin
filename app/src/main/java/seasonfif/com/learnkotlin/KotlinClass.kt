package seasonfif.com.learnkotlin

//默认所有类都是final
//如要派生子类必须使用open修饰
open class KotlinClass(a: Int){

    //初始化代码段
    //可直接使用主构造器参数
    init {
        echo(a)
    }

    /*constructor(a: Int){
        echo(a)
    }*/

    //次级构造函数
    constructor(a: Int, b: Int) : this(a){
        sum(a, b)
    }

    constructor(a: Int, b: Int, c: Int) : this(a, b){
        sum(a, b)
    }

    fun echo(a: Int){
        print(a)
    }

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum1(a: Int, b: Int): Unit {
        print(a + b)
    }

    //返回值为空 可省略Unit
    fun sum2(a: Int, b: Int) {
        print(a + b)
    }

    //表达式当做函数体
    fun max(a: Int, b: Int) = if (a > b) {
        print(a)
    } else {
        print(b)
    }

    //public修饰的方法，返回值类型不能省略
    public fun max1(a: Int, b: Int) : Unit = if (a > b) {
        print(a)
    } else {
        print(b)
    }

}
