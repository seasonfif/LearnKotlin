package com.seasonfif.learnkotlin.coroutine

import kotlinx.coroutines.*

/**
kotlin协程的三种启动方式
1.runBlocking:T
2.launch:Job
3.async/await:Deferred
*/

/**
 * 协程使用的4种CoroutineDispatcher
 * Unconfined      的含义是不给协程指定运行的线程, 逮到谁就使用谁, 启动它的线程直接执行它, 但被挂起后,
 *                 会由恢复它的线程继续执行, 如果一个协程会被挂起多次, 那么每次被恢复后, 都可能被不同线程继续执行.
 * CommonPool      协程内部创建一个线程池执行任务
 * HandlerContext  用android的handler处理你的代码块，构造方法需要提供Handler
 * UI              使用mainlooper初始化的HandlerContext
 *                 UI = HandlerContext(Handler(Looper.getMainLooper()), "UI")
 */

fun main(args: Array<String>) {
//    testRunBlocking()

//    testLaunch()

//    testCancel()

//    testLaunchDelay()

//    testAsync()

//    testLightThread()

//    testSync()

    testWithContext()
}


fun testRunBlocking(){
//  runBlocking启动的协程任务会阻断当前线程，直到该协程执行结束。
    runBlocking{
        repeat(10){
            println("协程执行---$it")
        }
        delay(500)
        println("协程所在线程-${Thread.currentThread().name}")
    }

    println("协程执行完毕")
}

fun testLaunch(){
//  launch启动的协程任务是不会阻塞线程的
    var job = GlobalScope.launch{
        delay(3000)
        println("协程所在线程-${Thread.currentThread().name}")
    }

//    job.cancel()
    println("主线程执行完毕")
    runBlocking {
        //join方法会阻塞主线程，直到协程执行结束
        job.join()
    }
//    Thread.sleep(5000)
}

fun testCancel(){
    val job = GlobalScope.launch{
        var i = 0
        while (true){
            i++
            if (i % 100 == 0){
                print("$i.")
            }
            /**
             * 协程job由于使用了delay函数挂起，所以在调用cancel之后实现了真正的取消；
             * 但如果你将delay函数去除，那该协程存在循环计算而没有发生挂起操作，
             * 在这种情况下即使调用了cancel，协程状态也变为停止，但是循环操作仍然在继续
             * 此时，可以使用isActive来判断是不是发生了取消
             */
            delay(1)
        }
    }

    Thread.sleep(1500)
    job.cancel()
    Thread.sleep(1500)
    println("主线程执行完毕")
}

fun testLaunchDelay(){
//    延迟一个协程
    val job = GlobalScope.launch(start=CoroutineStart.LAZY){
        delay(1000)
        println("协程-LAZY")
    }

    job.start()
    Thread.sleep(3000)
    println("主线程")
}

fun testAsync(){
//  1.async和await是两个函数，这两个函数在我们使用过程中一般都是成对出现的。
//  2.async用于启动一个异步的协程任务，await用于去得到协程任务结束时返回的结果，结果是通过一个Deferred对象返回的。
//  本身不阻塞，使用await获取结果时会阻塞以等待协程的执行结果
    runBlocking {

        var job = async(Dispatchers.Unconfined){
            doAny()
        }

        println("协程执行完毕...${job.await()}")
    }
}

private suspend fun doAny(): Int {
    delay(3000)
    println("协程所在线程-${Thread.currentThread().name}")
    return 3
}

fun testLightThread() = runBlocking{

    var tset : MutableSet<String> = mutableSetOf()

    var jobs = List(10000){

        async (Dispatchers.Unconfined) {
            delay(1500)
            tset.add(Thread.currentThread().name)
            if (it%2000 == 0){
                println("${Thread.currentThread().name}.$it")
            }
        }
    }

    jobs.forEach {
        it.join()
    }

    println("线程数量：${tset.size}")
}

fun testSync() = runBlocking {

    val job1 = async(Dispatchers.Default){
        delay(3000)
        "job1"
    }

    val job2 = async(Dispatchers.Default){
        delay(4000)
        "job2"
    }

    println(job1.await() + job2.await())
}

fun testWithContext() {

    GlobalScope.launch {
        println("1: ${Thread.currentThread().name}")
        coroutineScope{
            println("2: ${Thread.currentThread().name}")
            withContext(Dispatchers.Default){
                println("3: ${Thread.currentThread().name}")
            }
        }

        println("4: ${Thread.currentThread().name}")

    }
    println("5: ${Thread.currentThread().name}")
    runBlocking {
        delay(2000)
    }
}
