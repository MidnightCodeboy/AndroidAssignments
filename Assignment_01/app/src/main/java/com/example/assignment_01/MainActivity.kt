package com.example.assignment_01

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.assignment_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var counter  = 0
    private lateinit var binding: ActivityMainBinding
    private val myCounter: MyCounter = MyCounter("0")



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myCounter = myCounter

        setCounterText()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("counter", counter); // use @string thingy instead of hard coded param name
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle){
        super.onRestoreInstanceState(savedInstanceState)

        counter = savedInstanceState.getInt("counter")
        setCounterText()
    }

    fun setCounterText(){
        //binding.counterDisplay.text = counter.toString()
        binding.myCounter.counter = counter.toString();
    }


    fun onToastClick(view: View) {
        Toast.makeText(applicationContext, "Hello " + counter.toString(), Toast.LENGTH_LONG).show()
    }

    fun onUpButtonClick(view: View) {
        counter++
        setCounterText()
    }

    fun onDownButtonClick(view: View) {
        counter--
        setCounterText()
    }

}