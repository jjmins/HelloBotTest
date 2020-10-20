package com.jjmin.hellobottest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.jjmin.hellobottest.R
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        var issueNumber = intent.getStringExtra("issueNumber") as String
        var body = intent.getStringExtra("body") as String

        supportActionBar!!.title = issueNumber

        issueContentTv.text = body

    }
}
