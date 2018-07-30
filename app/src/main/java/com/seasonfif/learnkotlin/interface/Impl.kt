package com.seasonfif.learnkotlin.`interface`

class Impl : IA, IB{
    override fun action() {
        super.action()
        println("impl action")
    }

    override fun foo() {
        super<IA>.foo()
        super<IB>.foo()
        println("impl foo")
    }


    override fun test() {
        println("Impl test")
    }

    companion object {
        val IMPL = "伴生属性，类似于static"

        fun copy(){
            println("copy")
        }
    }
}

fun main(args: Array<String>) {
    Impl().action()
    Impl().foo()
//    Impl().test()
    println(Impl().extends(1,2))
    println(Impl.IMPL)
    Impl.copy()
    S.paste()
}

fun Impl.extends(a:Int, b:Int): String{
    this.test()
    println("扩展的test $a $b")
    return "返回值"
}

object S{
    fun paste(){
        println("paste")
    }
}