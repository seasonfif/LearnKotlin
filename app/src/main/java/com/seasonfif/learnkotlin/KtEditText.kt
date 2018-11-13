package com.seasonfif.learnkotlin

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast

class KtEditText : EditText {

    constructor(context: Context) : super(context, null)

    constructor(context: Context, attributeSet: AttributeSet) : this(context, attributeSet, 0)

    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(context, attributeSet, defStyleAttr){
        customSelectionActionModeCallback = object : ActionMode.Callback{
            /**
             * Called to report a user click on an action button.
             *
             * @param mode The current ActionMode
             * @param item The item that was clicked
             * @return true if this callback handled the event, false if the standard MenuItem
             * invocation should continue.
             */
            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                var msg = ""
                when(item?.itemId){
                    R.id.custome1 ->{
                        msg = item?.title.toString()
                    }
                    R.id.custome2 ->{
                        msg = item?.title.toString()
                    }
                }
                Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
                return false
            }

            /**
             * Called when action mode is first created. The menu supplied will be used to
             * generate action buttons for the action mode.
             *
             * @param mode ActionMode being created
             * @param menu Menu used to populate action buttons
             * @return true if the action mode should be created, false if entering this
             * mode should be aborted.
             */
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                var menuInflater = mode?.menuInflater
                menuInflater?.inflate(R.menu.selection_action_menu, menu)
                return true
            }

            /**
             * Called to refresh an action mode's action menu whenever it is invalidated.
             *
             * @param mode ActionMode being prepared
             * @param menu Menu used to populate action buttons
             * @return true if the menu or action mode was updated, false otherwise.
             */
            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                Log.e("KtEditText", mode?.title.toString())
                return false
            }

            /**
             * Called when an action mode is about to be exited and destroyed.
             *
             * @param mode The current ActionMode being destroyed
             */
            override fun onDestroyActionMode(mode: ActionMode?) {
                Log.e("KtEditText", mode?.title.toString())
            }

        }
    }

}