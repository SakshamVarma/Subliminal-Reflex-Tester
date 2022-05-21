package com.example.subliminal

import android.annotation.SuppressLint
import android.graphics.Color.red
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import com.example.subliminal.R.color
import com.example.subliminal.R.color.*
import com.example.subliminal.databinding.ActivityMain2Binding
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt

class MainActivity2 : AppCompatActivity() {
    private lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)


    }
    //var indicator = false
    var reflexT : Float = 0.0f
    val timer = object: CountDownTimer(6500, 2000) {
        //var i : Int = 3
        override fun onTick(millisUntilFinished: Long) {
            //Toast.makeText(this@MainActivity2, (millisUntilFinished/2000).toString(),Toast.LENGTH_SHORT).show()

            if(millisUntilFinished == 0.toLong())
            {
                binding.timer.text="Go!"
                cancel()
            }
            binding.timer.text=(millisUntilFinished/2000).toString()
        }

        @SuppressLint("ResourceAsColor")
        override fun onFinish() {
            //startgame(binding.button1)
//            binding.button1.text = "STOP"
            var loopvar = true
            while(loopvar){
                if(Random.nextInt(0,20)==11) {
                    binding.indicatorLeft.setBackgroundResource(R.drawable.indicator_change)
                    binding.indicatorMiddle.setBackgroundResource(R.drawable.indicator_change)
                    binding.indicatorRight.setBackgroundResource(R.drawable.indicator_change)
                    countdown.start()
                    loopvar=false
                }
            }


//            while(true)
//            {
//                if(Random.nextInt(0,10) == 2)
//
//            }
        }
    }

    val countdown = object: CountDownTimer(10000,10){

        override fun onTick(reflexTime: Long) {
            reflexT=(10f-(reflexTime.toFloat()/1000f))
//            if(indicator)
//            {
//
//                onFinish()
//            }
        }

        override fun onFinish() {
            Toast.makeText(this@MainActivity2, "${reflexT}s", Toast.LENGTH_SHORT-2000).show()
            binding.indicatorLeft.setBackgroundResource(R.drawable.indicator)
            binding.indicatorMiddle.setBackgroundResource(R.drawable.indicator)
            binding.indicatorRight.setBackgroundResource(R.drawable.indicator)
            reflexT=0.0f
            //indicator=false
        }
    }
    fun startgame(view: View) {

        timer.start()
    }

    fun stopgame(view: View) {
        //indicator=true
        countdown.onFinish()
        countdown.cancel()
        binding.timer.text="Ready?"
    }
}