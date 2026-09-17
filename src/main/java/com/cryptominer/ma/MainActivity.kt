package com.cryptominer.ma

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = TextView(this).apply {
            text = "CryptoMiner MA"
            textSize = 24f
            setPadding(20, 40, 20, 30)
        }

        val status = TextView(this).apply {
            text = "الحالة: متوقف"
            textSize = 18f
            setPadding(20, 20, 20, 20)
        }

        val startButton = Button(this).apply {
            text = "بدء التعدين"
            setOnClickListener {
                val intent = Intent(this@MainActivity, MiningService::class.java)
                startForegroundService(intent)
                status.text = "الحالة: يعمل"
            }
        }

        val stopButton = Button(this).apply {
            text = "إيقاف التعدين"
            setOnClickListener {
                val intent = Intent(this@MainActivity, MiningService::class.java)
                stopService(intent)
                status.text = "الحالة: متوقف"
            }
        }

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            addView(title)
            addView(status)
            addView(startButton)
            addView(stopButton)
        }

        setContentView(layout)
    }
}
