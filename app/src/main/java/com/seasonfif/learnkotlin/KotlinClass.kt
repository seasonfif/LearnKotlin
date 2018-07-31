package com.seasonfif.learnkotlin

fun topFun(a: Int, b: Int){
    println("topFun:" + (a+b))
}

//默认所有类都是final
//如要派生子类必须使用open修饰
open class KotlinClass(a: Int){

    var x : Int = 1
    val y : Int = 1

    lateinit var str: String
    val str1: String by lazy {
        "hello"
    }

    //初始化代码段
    //可直接使用主构造器参数
    init {
        echo(a)
        x++
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
        str = ""
        str.length
        a
    }

    //默认所有方法都是final
    //如要重写必须使用open修饰
    open fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sum1(a: Int, b: Int): Unit {
        print(a + b)
    }

    //返回值为空 可省略Unit
    fun sum2(a: Int, b: Int, callback: Callback) {
        print(a + b)
        callback.call()
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

    fun setCallback(callback: Callback){
        callback.call()
    }

    fun testSetCallback(){

        setCallback(mCallback)

    }

    var mCallback = object : Callback{
        override fun call() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    }

    fun testSum2(){
        sum2(1,2, object : Callback{
            override fun call() {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    interface Callback{

        fun call()
    }

    fun action(body:()->Unit){
        body()
    }

    //lambda 函数作为参数
    //不带参数且没有返回值
    fun action(a: Int, body:()->Unit){
        body()
    }

    //带参数且有返回值
    fun action1(a: Int, body:(Int, Int)->Int){
        body(3, 3)
    }

    //带参数且有返回值
    fun action2(a: Int, body:(Int)->Int){
        println(a + body(3))
    }

    //函数作为返回值
    val action3: (Int, Int)->Int = {x,y -> x+y}

    fun defaultParam(a: Int, b: Int = 1, c: Int = 1){
        println("defaultParam:" + (a+b+c))
    }

    fun actionLocal(a: Int) {
        var x = 3
        fun localFun(a: Int?) {
            println("localFun:$a")
        }

        localFun(a + x)
    }

    fun parseInt(str: String?): Int?{
        if (str == null) return null
        return str.toInt()
    }

    fun rangeTest(){
        val x = 5
        val y = 9
        if (x in 1..8) {
            println("x 在区间内")
        }

        if (y  !in 1..8) {
            println("y 不在区间内")
        }
    }

    fun rangeLoop(){
        for (x in 1..9) {
            println("$x")
        }

        for (x in 1..9 step 2) {
            println("$x")
        }

        for (x in 9 downTo 1) {
            println("$x")
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {

            //无参函数作为形参
            var l : ()->Unit = {
                println("hello")
            }

            KotlinClass(1).action({
                println("hello")
            })

            KotlinClass(1).action{
                println("hello")
            }

            KotlinClass(1).action(l)

            //有参有返回值函数作为形参

            var n : (Int, Int)->Int = {
                i, j ->
                i + j
            }
            KotlinClass(1).action1(1, n)

            KotlinClass(1).action1(1, {
                i, j ->
                i + j
            })

            KotlinClass(1).action1(1){
                i, j ->
                i + j
            }


            //lambda 闭包作为形参
            KotlinClass(1).action(1, {
                println("aaaaaaa")
            })

            //lambda闭包作为形参 函数最后一个参数是函数时可写在函数体外部
            KotlinClass(1).action(1){
                println("bbbbbbb")
            }


            var m:()->Unit = {
                println("ccccccc")
            }
            KotlinClass(1).action(1, m)

            KotlinClass(1).action1(1, {
                a,b ->
                a + b
            })

            KotlinClass(1).action1(1){
                a,b ->
                a + b
            }

            //只有一个参数时可省略参数定义，默认为it
            KotlinClass(1).action2(1){
                it + 2
            }

            println(KotlinClass(1).action3(1,1))

            KotlinClass(1).defaultParam(2)
            KotlinClass(1).defaultParam(a = 2,c = 3)

            KotlinClass(1).actionLocal(2)

            //类型后面加?表示可为空
            var age: String? = null
            //抛出空指针异常
//            val ages = age!!.toInt()
//            println(ages)
            //不做处理返回 null
            val ages1 = age?.toInt()
            println(ages1)
            //age为空返回-1
            val ages2 = age?.toInt() ?: -1
            println(ages2)


            println(KotlinClass(1).parseInt("2"))
            println(KotlinClass(1).parseInt(null))

            KotlinClass(1).rangeTest()
            KotlinClass(1).rangeLoop()
        }
    }
}
