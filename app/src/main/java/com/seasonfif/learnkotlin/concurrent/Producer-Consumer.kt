package com.seasonfif.learnkotlin.concurrent

import java.util.*

fun main(args: Array<String>) {

    val lock = Object()
    var queue : Queue<Int> = LinkedList()

    Producer(queue, 10, lock).start()
    Producer(queue, 10, lock).start()
    Consumer(queue, 10, lock).start()
    Consumer(queue, 10, lock).start()
    Consumer(queue, 10, lock).start()
}

class Producer : Thread{

    private var lock : Object
    private var queue : Queue<Int>
    private var maxSize : Int

    constructor(queue : Queue<Int>, maxSize : Int, lock : Object) : super(){
        this.queue = queue
        this.maxSize = maxSize
        this.lock = lock
    }

    override fun run() {
        synchronized(lock){
            while (true){
                sleep(1000)

                if (queue.size == maxSize){
                    lock.wait()
                }

                var num : Int = (Math.random() * 100).toInt()

                queue.offer(num)
                println(name + "生产：$num")

                lock.notifyAll()
            }
        }

    }
}

class Consumer : Thread{
    private var lock : Object
    private var queue : Queue<Int>
    private var maxSize : Int

    constructor(queue : Queue<Int>, maxSize : Int, lock : Object) : super(){
        this.queue = queue
        this.maxSize = maxSize
        this.lock = lock
    }

    override fun run() {
        while (true){
            synchronized(lock){
                sleep(1000)
                if (queue.isEmpty()){
                    lock.wait()
                }

                var num = queue.poll()
                println(name + "消费：$num")

                lock.notifyAll()
            }
        }
    }
}