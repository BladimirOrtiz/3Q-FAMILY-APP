package com.example.a3qfamily
import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.Button
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.util.Random
private val random = Random()
private var lastAngle = 0
class WhereRule : AppCompatActivity() {
    private lateinit var ruleta: ImageView
    private lateinit var buttonSpin: Button
    private lateinit var buttonNext: Button
    private lateinit var buttonExit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_where_rule)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        ruleta = findViewById(R.id.img_where)
        buttonSpin = findViewById(R.id.btn_spin3)
        buttonNext = findViewById(R.id.try_again)
        buttonExit = findViewById(R.id.btn_exit)

        // Configura el botón para girar la ruleta
        buttonSpin.setOnClickListener { rotateImage(ruleta) }

        // Configura el botón para cambiar la vista
// Configura el botón para cambiar la vista
        buttonNext.setOnClickListener { goToTryAgain() }
        buttonExit.setOnClickListener { exit() }
    }

    private fun rotateImage(view: View) {
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
    private fun goToTryAgain() {
        val intent = Intent(this, PanelRule::class.java)
        startActivity(intent)
    }
    private fun exit() {
        finishAffinity()
    }
}

