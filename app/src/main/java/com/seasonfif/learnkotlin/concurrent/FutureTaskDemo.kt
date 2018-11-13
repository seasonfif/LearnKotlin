package com.seasonfif.learnkotlin.concurrent

import java.util.concurrent.Callable
import java.util.concurrent.FutureTask

fun main(args: Array<String>) {

    var future : FutureTask<Int> = FutureTask(CalculateTask())
    var t : Thread = Thread(future)
    t.start()

    //Thread的join和FutureTask的get方法调用均会阻塞主线程的执行
    //然而后者可以同步等待执行的结果
    t.join()

//    println("取得结果：" + future.get())
    println("运行结束")


}

class CalculateTask : Callable<Int>{
    /**
     * Computes a result, or throws an exception if unable to do so.
     *
     * @return computed result
     * @throws Exception if unable to compute a result
     */
    override fun call(): Int {
        var sum = 0
        for (i in 1..1000){
            sum += i
        }
        return sum
    }
}