package com.seasonfif.learnkotlin

//子类有主构造函数， 则基类必须在主构造函数中初始化
class KotlinChildClass(a: Int) : KotlinClass(a) {

    constructor(a: Int, b: Int): this(a){

    }

    //子类重写必须使用 override
    override fun sum(a: Int, b: Int): Int {
        return 2
    }

}