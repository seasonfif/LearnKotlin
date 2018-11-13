package com.seasonfif.learnkotlin.concurrent

fun main(args: Array<String>) {

    //自执行闭包
    {
        x: Int,y: Int->
        println(x+y)
    }(1,2)

    test1()

    testNest("nest function", printMsg)

    test2()

    test3{
        i, j ->
        i+j
    }

    val count = justCount()
    println(count(1))
    println(count(1))
    println(count(1))

    testInfix()

    testStandard()

}

val printMsg = {
    msg : String ->
    println(msg)
}

fun test1(){

    printMsg.invoke("hahha")
    printMsg("ssss")
}

fun test2(){

    fun adds(body : (Int, Int)->Int) : Int{
        return body(1,2)
    }

    println(adds { i, j ->  i+j})

}

fun test3(callback : (Int, Int)->Int){

    var a = 10
    var b = 20

    val c = callback(a,b)
    println(c)
}

//闭包就是在函数被创建的时候，存在的一个私有作用域，并且能够访问所有的父级作用域。
//每个功能模块我们都能够拆解到不同fun里，不同fun里的变量保持相互调用的可能性，相互独立还彼此不影响
fun justCount():(Int)->Int{

    var count = 0

    return {
        it + count ++
    }
}

fun testNest(msg: String, function : (String)->Unit){
    function(msg)
}

fun testInfix(){
    var user = User("season")
    user.show(user.history)
    user append "fif"
    user.show(user append "fif")
}

class User(first: String){

    var history : String = first

    infix fun append(s : String) : String{
        history += s
        return history
    }

    fun show(str : String) {
        println(str)
    }

}

fun testStandard(){

//调用某对象的run函数，在函数块内可以通过 this 指代该对象。返回值为函数块的最后一行或指定return表达式
    val a = run {
        println("run")
        3
    }

    println("run:$a")

    var me = "season"
    var newme1 = me.run {
        var prefix = "fif"
        this + prefix
    }
    println("newme1：$newme1")


//调用某对象的apply函数，在函数块内可以通过 this 指代该对象。返回值为该对象自己。
    var newme2 = me.apply {
        var prefix = "fif"
        this + prefix
        prefix
    }
    println("newme2：$newme2")

    var ll = mutableListOf("11", "22", "33")
    ll.apply {
        this.add("44")
    }
    println(ll.toString())

//调用某对象的let函数，则该对象为函数的参数。在函数块内可以通过 it 指代该对象。返回值为函数块的最后一行或指定return表达式。
    me.let {
        println("let:lenth ${it.length}")
        3
    }


//调用某对象的also函数，则该对象为函数的参数。在函数块内可以通过 it 指代该对象。返回值为该对象自己。
//with函数和前面的几个函数使用方式略有不同，因为它不是以扩展的形式存在的。
//with是将某对象作为函数的参数，在函数块内可以通过 this 指代该对象。返回值为函数块的最后一行或指定return表达式。

    var newme3 = with(me){
        this + "fif"
        33
        "1234"
    }.reversed()
    println("newme3：$newme3")


}