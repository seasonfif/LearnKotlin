package com.seasonfif.learnkotlin

object RunMain {

    @JvmStatic
    fun main(args: Array<String>) {
        var cls = KotlinClass(1)
        cls.action(1, {
            print("hahahah")
        })
    }
}