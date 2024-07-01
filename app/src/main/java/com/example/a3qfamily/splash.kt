package com.example.a3qfamily

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent

import android.os.Handler
import android.os.Looper
class splash : AppCompatActivity() {
    private lateinit var handler: Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            startActivity(Intent(this,PanelRule::class.java))
            this.finish()
        },3000)
    }
    }
