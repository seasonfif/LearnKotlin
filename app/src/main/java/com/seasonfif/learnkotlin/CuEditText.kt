package com.seasonfif.learnkotlin

import android.content.Context
import android.text.method.MovementMethod
import android.util.AttributeSet
import android.view.ContextMenu
import android.view.MotionEvent
import android.widget.EditText

class CuEditText : EditText {

    constructor(context: Context) : super(context, null)

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr){

    }

    override fun getDefaultEditable(): Boolean {
        return false
    }

    override fun getDefaultMovementMethod(): MovementMethod? {
        return null
    }

    override fun onCreateContextMenu(menu: ContextMenu?) {
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return super.onTouchEvent(event)
    }

}