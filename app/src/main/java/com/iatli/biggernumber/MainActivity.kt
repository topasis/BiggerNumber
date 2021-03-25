package com.iatli.biggernumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {
    private var points = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateNumbers()

    }

    fun common_btn_call(view: View){
        val btn_left = findViewById<Button>(R.id.btn_left)
        val btn_right = findViewById<Button>(R.id.btn_right)

        val number_left: Int = btn_left.getText().toString().toInt()
        val number_right: Int = btn_right.getText().toString().toInt()


        if (number_left > number_right && view.getId() == R.id.btn_left ||
                number_left < number_right && view.getId() == R.id.btn_right){
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show()
            points ++
        }
        else{
            Toast.makeText(this, "Nooo!", Toast.LENGTH_SHORT).show()
            points --
        }
        // update points in UI
        findViewById<TextView>(R.id.tv_points).setText("Points: $points")

        //generate new question
        generateNumbers()
    }

    private fun generateNumbers(){
        val r = Random()
        var number1 = r.nextInt(20)
        val number2 = r.nextInt(20)
        while (number1 == number2)
        {
            number1 = r.nextInt(20)
        }

        val btn_left = findViewById<Button>(R.id.btn_left)
        val btn_right = findViewById<Button>(R.id.btn_right)

        btn_left.setText("$number1")
        btn_right.setText("$number2")
    }

}