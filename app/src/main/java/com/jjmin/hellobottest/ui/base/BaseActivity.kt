package com.jjmin.hellobottest.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.toast


abstract class BaseActivity : AppCompatActivity() , BaseContract.View{

    abstract var initLayoutResourse : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initLayoutResourse)
    }

    override fun toastMessage(text: String) {
        toast(text)
    }
}