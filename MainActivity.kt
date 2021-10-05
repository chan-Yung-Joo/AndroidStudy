package com.example.chapter04_lab1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.ArithmeticException

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lateinit var tNum1 : EditText
        lateinit var tNum2 : EditText
        lateinit var addBtn : Button
        lateinit var subBtn : Button
        lateinit var mulBtn : Button
        lateinit var divBtn : Button
        lateinit var res : TextView

        lateinit var num1 : String
        lateinit var num2 : String
        var result : Int? = null

        tNum1 = findViewById<EditText>(R.id.et1)
        tNum2 = findViewById<EditText>(R.id.et2)
        addBtn = findViewById<Button>(R.id.btnAdd)
        subBtn = findViewById<Button>(R.id.btnSub)
        mulBtn = findViewById<Button>(R.id.btnMul)
        divBtn = findViewById<Button>(R.id.btnDiv)
        res = findViewById<TextView>(R.id.textRes)

        // setOnTouchListener -> 람다식을 이용
        addBtn.setOnTouchListener { view, motionEvent ->
            num1 = tNum1.text.toString() // TextEdit에 있는 값을 문자열로 변환하여 num1에 저장
            num2 = tNum2.text.toString() // TextEdit에 있는 값을 문자열로 변환하여 num2에 저장
            result = Integer.parseInt(num1) + Integer.parseInt(num2) // 연산을 진행 (wrapper 클래스 활용)
            res.text = "계산 결과 >> " + result.toString() // 연산 결과를 다시 문자열로 바꾸어 textview에 저장
            false
        }

        subBtn.setOnTouchListener { view, motionEvent ->
            num1 = tNum1.text.toString()
            num2 = tNum2.text.toString()
            result = Integer.parseInt(num1) - Integer.parseInt(num2)
            res.text = "계산 결과 >> " + result.toString()
            false
        }

        mulBtn.setOnTouchListener { view, motionEvent ->
            num1 = tNum1.text.toString()
            num2 = tNum2.text.toString()
            result = Integer.parseInt(num1) * Integer.parseInt(num2)
            res.text = "계산 결과 >> " + result.toString()
            false
        }

        divBtn.setOnTouchListener { view, motionEvent ->
            num1 = tNum1.text.toString()
            num2 = tNum2.text.toString()
            try {
                result = Integer.parseInt(num1)/Integer.parseInt(num2)
                res.text = "계산 결과 >> " + result.toString()
                false
            }
            catch (e : ArithmeticException){
                Toast.makeText(this, "연산을 진행할 수 없습니다!!", Toast.LENGTH_SHORT).show()
                false
            }
        }
    }
}