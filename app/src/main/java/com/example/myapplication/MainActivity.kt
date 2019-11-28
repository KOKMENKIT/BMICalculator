package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCal.setOnClickListener() {
            //todo: invoke function to calculate bmi
            try{

                val Height: Double
            val Weight: Double
            Height = (txtheightinput.text.toString().toDouble())
            Weight = (txtweightinput.text.toString().toDouble())

            val bmi = CalculateBML (Height, Weight)


            //todo: display image and bmi result
            if(bmi < 18.5){
                imageView.setImageResource(R.drawable.under)
                lblBMIresult.text = (String.format("%.2f",bmi) + "(Under)")
            }else if(bmi >= 18.5 && bmi <= 24.9){
                imageView.setImageResource(R.drawable.normal)
                lblBMIresult.text = (String.format("%.2f",bmi) + "(Normal)")
            }else if(bmi > 25){
                imageView.setImageResource(R.drawable.over)
                lblBMIresult.text = (String.format("%.2f",bmi) + "(Over)")
            }

            }catch (e: Exception){
                //Toast.makeText(applicationContext, "Please enter the number", Toast.LENGTH_SHORT).show()

                val toast: Toast = Toast.makeText(applicationContext, "Please enter the number", Toast.LENGTH_SHORT)

                toast.setGravity(Gravity.CENTER, 0,0)
                toast.show()
            }

        }

        btnReset.setOnClickListener() {
            //todo: clear input & result
            //todo: clear image

            txtheightinput.setText("")
            txtweightinput.setText("")
            lblBMIresult.setText("")

            imageView.setImageResource(R.drawable.empty)

            txtweightinput.requestFocus()

        }

    }

    //todo: function to calculate BMI
    private fun CalculateBML (height: Double, weight:Double): Double{
        return weight/(height*height)
    }
}
