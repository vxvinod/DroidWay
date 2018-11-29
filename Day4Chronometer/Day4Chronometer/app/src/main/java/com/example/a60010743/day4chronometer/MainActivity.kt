package com.example.a60010743.day4chronometer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Chronometer
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val chronometerView = findViewById<Chronometer>(R.id.chronometer_time)
        val controlButton = findViewById<Button>(R.id.control_button)

        controlButton?.setOnClickListener( object : View.OnClickListener {
            internal var isPlaying = false
            override fun onClick(v: View) {
                if (!isPlaying) {
                    chronometerView.start()
                    isPlaying = true
                } else {
                    chronometerView.stop()
                    isPlaying = false
                }


                controlButton.setText(if (isPlaying) R.string.stop else R.string.start)
                Toast.makeText(this@MainActivity, getString(if (isPlaying) R.string.start else R.string.stop), Toast.LENGTH_LONG).show()

            }

        })





    }
}
