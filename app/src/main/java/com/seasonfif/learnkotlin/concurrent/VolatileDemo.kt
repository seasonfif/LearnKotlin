package com.seasonfif.learnkotlin.concurrent

var time = 0

@Volatile
var change = false

fun main(args: Array<String>) {

    Thread {
        while (true){
            Thread.sleep(1000)
            add()
        }
    }.start()

    Thread {
        while (true){
            Thread.sleep(1000)
            add()
        }
    }.start()

    Thread {
        while (true){
            Thread.sleep(1000)
            println("time: $time")
        }
    }.start()

}

@Synchronized
fun add(){
    time ++
}