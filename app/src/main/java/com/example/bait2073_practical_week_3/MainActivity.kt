package com.example.bait2073_practical_week_3

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var nickNameEditText: EditText
    lateinit var nickNameTextView: TextView
    lateinit var confirmButton: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nickNameTextView = findViewById(R.id.nickNameTextView)
        nickNameEditText = findViewById(R.id.nickNameEditText)
        confirmButton = findViewById(R.id.confirmButton)

        confirmButton.setOnClickListener { changeNickName(it)}
        nickNameTextView.setOnClickListener{ updateNickName()}
    }

    private fun changeNickName(view: View){
        if (nickNameEditText.text.isNullOrBlank()) {
            return
        }
        nickNameTextView.text = nickNameEditText.text.toString()
        nickNameTextView.visibility = View.VISIBLE
        nickNameEditText.visibility = View.GONE
        confirmButton.visibility = View.GONE

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

        // Bapak kau
    }

    private fun updateNickName(){

        nickNameEditText.visibility = View.VISIBLE
        confirmButton.visibility = View.VISIBLE

        nickNameEditText.requestFocus()
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(nickNameEditText, 0)
    }
}