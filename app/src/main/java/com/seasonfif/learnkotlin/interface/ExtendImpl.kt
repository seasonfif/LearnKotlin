package com.seasonfif.learnkotlin.`interface`

import kotlin.properties.Delegates

class ExtendImpl {

    var name: String by Delegates.observable("default"){
        _, old, new ->
        println("old：$old -> new：$new")
    }

    val array= intArrayOf(1,2,3,4)
    val set= setOf<Int>(1,2,3,4)
    val list= listOf<Int>(1,2,3,4)
    val list1= mutableListOf<Int>(1,2,3,4)
    val map= mapOf<Int, String>(1 to "a", 2 to "b", 3 to "c", 4 to "d", 5 to "e")

    fun testWhen(s : String){
        val fruit = setOf("apple", "banana", "kiwi")
        val animal = setOf("dog", "cat", "zebra")
        when {
            s in fruit -> println("fruit")
            s in animal -> println("animal")
            else -> println("nothing")
        }

        list1.add(1)
        println(array.get(1))
        println(list[1])

        for (value in list){
            println(value)
        }

        for ((index,value) in list.withIndex()){
            println("$index ---> $value")
        }
    }
}

fun main(args: Array<String>) {
    Impl().extends(2,2)
    println(Impl.IMPL)
    Impl.copy()
    S.paste()

    val impl = ExtendImpl()
    println(impl.name)
    impl.name = "first"
    impl.name = "again"

    impl.testWhen("aple")
}