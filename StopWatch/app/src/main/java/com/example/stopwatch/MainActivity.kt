package com.example.stopwatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.TestLooperManager
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.util.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

    private var time = 0
    private var timerTask : Timer? = null
    private var isRunning = false
    private var lap = 1


    lateinit var milliTextView : TextView
    lateinit var secTextView: TextView
    lateinit var secEditText: EditText
    lateinit var setButton: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        milliTextView = findViewById<TextView>(R.id.milliTextView)
        secTextView = findViewById(R.id.secTextView)
        secEditText = findViewById(R.id.secEditText)
        setButton = findViewById(R.id.setButton)

        setButton.setOnClickListener {
            time = secEditText.text.toString().toInt()*100
            start()
        }

    }

    private fun start() {

        timerTask = timer(period = 10) {
            time--
            val sec = time/ 100
            val milli = time % 100

            if(sec == 0 && milli ==0) timerTask?.cancel()
            runOnUiThread{
                secTextView.text = "$sec"
                milliTextView.text = "$milli"
            }
        }
    }
}