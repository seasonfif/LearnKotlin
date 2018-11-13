package com.seasonfif.learnkotlin.concurrent

import java.util.concurrent.Callable
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

fun main(args: Array<String>) {

    val pool : ExecutorService = Executors.newFixedThreadPool(5)
    var f = pool.submit (Runnable{
        var sum = 0
        for (i in 1..100) {
            sum += i
        }
        println("sum1=$sum")
    }, String)

    println(f.get())

    var ff = pool.submit( Callable{
        var sum = 0
        for (i in 1..100){
            sum += i
        }
        println("sum2=$sum")
        sum
    })
    println(ff.get())

    var fff = pool.submit { Callable<Int> {
        var sum = 0
        for (i in 1..100) {
            sum += i
        }
        println("sum3=$sum")
        sum
    }
    }

    println(fff.get())

//    var ffff = pool.submit()

}