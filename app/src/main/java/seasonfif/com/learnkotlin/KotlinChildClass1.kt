package seasonfif.com.learnkotlin

class KotlinChildClass1 : KotlinClass {

    //子类没有主构造函数，则在每一个次级构造函数中用 super 关键字初始化基类，或者代理另一个构造函数
    constructor(a: Int): super(a){

    }

    constructor(a: Int, b: Int): this(a){

    }

}