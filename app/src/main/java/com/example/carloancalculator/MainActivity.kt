package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCal.setOnClickListener {
            calculateLoan()
        }
    }
    private fun calculateLoan(){
        val carPrice=editTextCarPrice.text.toString().toInt()
        val downPayment=editTextDownPayment.text.toString().toInt()
        val loanPeriod=editLoanPeriod.text.toString().toInt()
        val interestRate=editTextIRate.text.toString().toFloat()

        val loan=carPrice-downPayment;
        val interest=loan*interestRate*loanPeriod
        val monRepay=(loan+interest)/loanPeriod/12

        Loan.text=getString(R.string.Loan)+": ${loan}"
        Interest.text=getString(R.string.Interest)+": ${interest}"
        MPayment.text=getString(R.string.MonRepay)+": ${monRepay}"

    }

    fun resetInput(view: View) {
        editTextCarPrice.text=null
        editTextDownPayment.text=null
        editLoanPeriod.text=null
        editTextIRate.text=null
        Loan.text=null
        Interest.text=null
        MPayment.text=null
    }
}
