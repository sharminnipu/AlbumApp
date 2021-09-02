package com.sharminnipu.albumapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        goToActivity()
    }


    private fun goToActivity()
    {
        Handler().postDelayed({

                startActivity(Intent(applicationContext,MainActivity::class.java))

            finish()
        },2000)
    }
}