package com.example.roadlover

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.slider.Slider
import java.text.NumberFormat
import java.util.*

class RangeSliderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_range_slider)

        val slider=findViewById<Slider>(R.id.slider)
        slider.setLabelFormatter { value: Float ->
//            val format = NumberFormat.getCurrencyInstance()
//            format.maximumFractionDigits = 0
//            format.currency = Currency.getInstance("USD")
//            format.format(value.toDouble())
            println(value?.toDouble()).toString()
        }

        slider.addOnSliderTouchListener(object : Slider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: Slider) { 
                // Responds to when slider's touch event is being started
//                println("changed")

            }

            override fun onStopTrackingTouch(slider: Slider) {
                // Responds to when slider's touch event is being stopped
//                println("changed")

            }
        })

        slider.addOnChangeListener { slider, value, fromUser ->
            // Responds to when slider's value is changed
            println(value)
//            Toast.makeText(this, "changed", Toast.LENGTH_SHORT).show()
        }
    }
}