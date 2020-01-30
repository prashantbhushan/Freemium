package com.prashant.freemiumnews.ui.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.prashant.freemiumnews.R
import com.prashant.freemiumnews.ui.newslist.NewsListActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnLogin.setOnClickListener { startActivity(Intent(this, NewsListActivity::class.java)) }
    }
}
