package com.example.demo

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DisplayActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        val a = intent.getIntExtra("inputA", 0)
        val b = intent.getIntExtra("inputB", 0)
        val result = intent.getIntExtra("result", 0)
        val buildInfo = intent.getStringExtra("buildInfo") ?: ""

        findViewById<TextView>(R.id.calculationText).text =
            "Calculation: $a + $b = $result"
        findViewById<TextView>(R.id.buildInfoText).text = buildInfo
    }
}
