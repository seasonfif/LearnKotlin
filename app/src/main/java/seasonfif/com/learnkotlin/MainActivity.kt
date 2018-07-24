package seasonfif.com.learnkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var tv: TextView ?= null
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if ( tv != null){

        }

        tv?.setText("安全调用")

//        强制调用  tv为空时NPE
        tv!!.text

        var str = tv?.text ?: "默认值"

        KotlinClass(1).max1(1, 2)
    }
}
