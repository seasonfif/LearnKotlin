package com.seasonfif.learnkotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.*

class MainActivity : AppCompatActivity() {

    private var tv: TextView ?= null
    lateinit var btn: Button

    private var count = 0
    private lateinit var defer1 : Deferred<String>

    private lateinit var defer2 : Deferred<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tv = findViewById(R.id.tv)
        btn = findViewById(R.id.btn)


        btn.setOnClickListener {
            count ++
//            updateUI()
            getData()
        }

        initCoroutine()

    }

    private fun updateUI(){
        GlobalScope.launch (Dispatchers.Main){
            tv?.apply {
                this.text = defer1.await() + "\n" + defer2.await()
            }
        }
    }

    var inner = 0
    private fun initCoroutine() = GlobalScope.launch{
        defer1 = async(start = CoroutineStart.LAZY){
            println("defer1 : $count")
            delay(2000)
            "defer1: ${Thread.currentThread().name} :: $count"

        }

        defer2 = async (start = CoroutineStart.LAZY){
            println("defer2 : $count")
            inner ++
            delay(3000)
            "defer2: ${Thread.currentThread().name} :: $inner"
        }
    }

    private fun getData(){

        GlobalScope.launch(Dispatchers.Main){
            val async1 = async {
                delay(2000)
                "async1: ${Thread.currentThread().name}"
            }

            val async2 = async {
                delay(1000)
                "async2: ${Thread.currentThread().name}"
            }

            tv?.apply {
                this.text = async1.await() + "\n" + async2.await()
            }

        }
    }
}
