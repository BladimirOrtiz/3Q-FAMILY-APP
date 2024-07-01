package com.example.a3qfamily

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random
import android.view.View
import android.content.Intent
import android.media.MediaPlayer


class PanelRule : AppCompatActivity() {

    private lateinit var ruleta: ImageView
    private lateinit var buttonSpin: Button
    private lateinit var buttonNext: Button
    private val random = Random()
    private var lastAngle = 0
    lateinit var  soundfont : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_panel_rule)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        soundfont = MediaPlayer.create(this, R.raw.water)
        soundfont.start()


        // Inicializa los elementos del layout
        ruleta = findViewById(R.id.img_whorule)
        buttonSpin = findViewById(R.id.btn_spin)
        buttonNext = findViewById(R.id.btn_wd)

        // Configura el botón para girar la ruleta
        buttonSpin.setOnClickListener { spin() }

        // Configura el botón para cambiar la vista
        buttonNext.setOnClickListener { goToWDActivity() }
    }

    private fun spin() {
        val newAngle = random.nextInt(3600) + 360
        val rotateAnimation = RotateAnimation(
            lastAngle.toFloat(), newAngle.toFloat(),
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation.duration = 3000
        rotateAnimation.fillAfter = true

        lastAngle = newAngle % 360

        ruleta.startAnimation(rotateAnimation)
    }

    private fun goToWDActivity() {
        val intent = Intent(this, WDRule::class.java)
        startActivity(intent)
    }
}
