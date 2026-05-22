package com.example.demo

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    external fun addNumbers(a: Int, b: Int): Int
    external fun getBuildInfo(): String

    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputA = findViewById<EditText>(R.id.inputA)
        val inputB = findViewById<EditText>(R.id.inputB)
        val calcBtn = findViewById<Button>(R.id.calcBtn)

        calcBtn.setOnClickListener {
            val a = inputA.text.toString().toIntOrNull() ?: 0
            val b = inputB.text.toString().toIntOrNull() ?: 0
            val result = addNumbers(a, b)
            val buildInfo = getBuildInfo()

            val intent = Intent(this, DisplayActivity::class.java).apply {
                putExtra("result", result)
                putExtra("buildInfo", buildInfo)
                putExtra("inputA", a)
                putExtra("inputB", b)
            }
            startActivity(intent)
        }
    }
}
