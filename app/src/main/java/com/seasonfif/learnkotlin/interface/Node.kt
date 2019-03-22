package com.seasonfif.learnkotlin.`interface`

interface Node<out T>{
    val data : T
    fun trim() : T
}


interface Tree<in T>{
    fun data(d : T)
    fun trim(value : List<T>)
}