package com.example.practice_7_1

import android.media.VolumeShaper
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AllExamples = findViewById<TextView>(R.id.txtAllExamples)
        NumberRight = findViewById<TextView>(R.id.txtNumberRight)
        NumberWrong = findViewById<TextView>(R.id.txtNumberWrong)
        PrecentageCorrectAnswers = findViewById<TextView>(R.id.txtPrecentageCorrectAnswers)
        FirstOperand = findViewById<TextView>(R.id.txtFirstOperand)
        Ooperation = findViewById<TextView>(R.id.txtOperation)
        TwoOperand = findViewById<TextView>(R.id.txtTwoOperand)
        EditValue = findViewById<TextView>(R.id.editValue)
        Start = findViewById<Button>(R.id.btnStart)
        Check = findViewById<Button>(R.id.btnCheck)
    }

    lateinit var AllExamples: TextView
    lateinit var NumberRight: TextView
    lateinit var NumberWrong: TextView
    lateinit var PrecentageCorrectAnswers: TextView
    lateinit var FirstOperand: TextView
    lateinit var Ooperation: TextView
    lateinit var TwoOperand: TextView
    lateinit var EditValue: TextView
    lateinit var Start: Button
    lateinit var Check: Button


    var i: Int = 0
    var j: Int = 0
    var SumTrueFalse: Int = 0



    fun btnStartFun(view: View) {
        Start.isEnabled = false
        Check.isEnabled = true
        EditValue.text = ""
        EditValue.isEnabled=true



        var random = Random
        var FirstNumRand= random.nextInt(10,100)
        FirstOperand.setText("" + FirstNumRand)
        var SecondNumRand = random.nextInt(10,100)
        TwoOperand.setText("" + SecondNumRand)
    }

    fun btnCheckFun(view: View) {
        Start.isEnabled = true
        Check.isEnabled = false
        EditValue.isEnabled=false

        if (EditValue.text.toString().isEmpty())
            return
        when (Ooperation.text.toString()) {
            "+" -> {
                if ((FirstOperand.text.toString().toInt() + TwoOperand.text.toString().toInt()) == EditValue.text.toString().toInt()
                ) {
                    i++
                } else {
                    j++
                }
            }
            "-" -> {
                if ((FirstOperand.text.toString().toInt() - TwoOperand.text.toString().toInt()) == EditValue.text.toString().toInt()
                ) {
                    i++
                } else {
                    j++
                }
            }
            "*" -> {
                if ((FirstOperand.text.toString().toInt() * TwoOperand.text.toString()
                        .toInt()) == EditValue.text.toString().toInt()
                ) {
                    i++
                    
                } else {
                    j++
                }
            }
            "/" -> {
                if ((FirstOperand.text.toString().toInt() / TwoOperand.text.toString()
                        .toInt()) == EditValue.text.toString().toInt()
                ) {
                    i++
                } else {
                    j++
                }
            }
        }


        NumberRight.text = i.toString()
        NumberWrong.text = j.toString()
        Сount()
        Percent()


        EditValue.isEnabled=false
    }

        fun Transform(){
            var random = Random
            var FirstNumRand= random.nextInt(10,100)
            var SecondNumRand = random.nextInt(10,100)
            FirstOperand.setText("" + FirstNumRand)
            TwoOperand.setText("" + SecondNumRand)
        }

        fun Сount(){
            SumTrueFalse = i + j
            AllExamples.text = SumTrueFalse.toString()
        }

        fun Percent(){
            var Perc = 0.00
            Perc = ((i.toDouble()/(SumTrueFalse.toDouble()/100)))
            PrecentageCorrectAnswers.text="%.2f".format(Perc) + "%".toString()
        }

        fun RandOperation(){
            val RandOperat = arrayOf("+","-","*","/")
            var Rand = RandOperat.random()
            if(Rand == "/")
            {
                if ((FirstOperand.text.toString().toInt() % TwoOperand.text.toString().toInt()) != 0)
                {
                    Rand = "+"
                    FirstOperand.text = ((FirstOperand.text.toString().toInt() / TwoOperand.text.toString()
                        .toInt() * TwoOperand.text.toString().toInt()).toString())

                    TwoOperand.text = (TwoOperand.text.toString().toInt()).toString()
                }
            }
            Ooperation.text = Rand
        }
    }

