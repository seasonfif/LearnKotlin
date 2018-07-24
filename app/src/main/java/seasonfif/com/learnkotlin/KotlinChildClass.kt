package seasonfif.com.learnkotlin

//子类有主构造函数， 则基类必须在主构造函数中初始化
class KotlinChildClass(a: Int) : KotlinClass(a) {

    constructor(a: Int, b: Int): this(a){

    }

}