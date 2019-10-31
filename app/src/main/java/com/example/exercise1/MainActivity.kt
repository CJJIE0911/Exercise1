package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            //val = value or var = variable
            val car_price = editTextCarPrice.text.toString().toFloat()
            val down_payment = editTextDownPayment.text.toString().toInt()
            val loan_period = editTextLoanPeriod.text.toString().toInt()
            val interest_rate = editTextInterestRate.text.toString().toFloat()
            //TODO continue the calculation here
            val loan = car_price-down_payment
            val interest = loan * interest_rate/100 * loan_period
            val monthly_repayment =(loan+interest)/loan_period/12
            textViewLoan.text= getString(R.string.loan) + "${loan}"
            textViewInterest.text = getString(R.string.interest)+"${interest}"
            textViewMonthlyPayment.text = getString(R.string.monthly_repayment)+"${monthly_repayment}"
        }
    }

    fun resetInputs(view: View) {
        //TODO reset all inputs and outputs lar
        editTextCarPrice.text.clear()
        editTextDownPayment.text.clear()
        editTextCarPrice.text.clear()
        editTextLoanPeriod.text.clear()
        textViewLoan.text= getString(R.string.loan)
        textViewInterest.text = getString(R.string.interest)
        textViewMonthlyPayment.text = getString(R.string.monthly_repayment)
    }
    fun showResult(view: View) {
        val car_price :String = editTextCarPrice.text.toString()
        if(car_price.length==0){
            editTextCarPrice.setError("Please enter the car price")
            return
        }

        val down_payment :String = editTextDownPayment.text.toString()
        if(down_payment.length==0){
            editTextDownPayment.setError("Please enter the down payment")
            return
        }

        val loan_period :String = editTextLoanPeriod.text.toString()
        if(loan_period.length==0){
            editTextLoanPeriod.setError("Please enter the loan period")
            return
        }

        val interest_rate :String = editTextInterestRate.text.toString()
        if(interest_rate.length==0){
            editTextInterestRate.setError("Please enter the interest rate")
            return
        }
    }
}
