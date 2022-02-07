package com.example.pifagor

import android.annotation.SuppressLint
import android.app.Activity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pifagor.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)
    }
    @SuppressLint("SetTextI18n")
    fun onClickCalculated(view: View)
    {
        if(!isFieldEmpty()){
            val result = getString(R.string.result_info) + getResult()
            b.txResult.text =result
        }

    }

    private  fun isFieldEmpty() : Boolean{
        b.apply {
            if(edA.text.isNullOrEmpty()) edA.error = "Field must be filled"
            if(edB.text.isNullOrEmpty()) edB.error = "Field must be filled"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }
    private  fun getResult(): String
    {
        val editA: Double
        val editB: Double
        b.apply {
            editA = edA.text.toString().toDouble()
            editB = edB.text.toString().toDouble()
        }
        return sqrt( (editA.pow(2) + editB.pow(2))).toString()
    }
}