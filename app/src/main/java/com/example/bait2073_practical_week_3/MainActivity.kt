package com.example.bait2073_practical_week_3

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import com.example.bait2073_practical_week_3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
//    lateinit var nickNameEditText: EditText
//    lateinit var nickNameTextView: TextView
//    lateinit var confirmButton: Button

    lateinit var binding: ActivityMainBinding

    private var myName2: MyName = MyName(name = "JieShen")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // initialize binding object with activity_main layout
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myNameOne = myName2
//        setContentView(R.layout.activity_main)

//        nickNameTextView = findViewById(R.id.nickNameTextView)
//        nickNameEditText = findViewById(R.id.nickNameEditText)
//        confirmButton = findViewById(R.id.confirmButton)

//        confirmButton.setOnClickListener { changeNickName(it)}
//        nickNameTextView.setOnClickListener{ updateNickName()}

        binding.confirmButton.setOnClickListener { changeNickName(it) }
        binding.nickNameTextView.setOnClickListener { updateNickName() }
        binding.callButton.setOnClickListener { callMe(it) }
    }

    private fun changeNickName(view: View) {
        binding.apply {
            if (!nickNameEditText.text.isNullOrBlank()) {
//            binding.nickNameTextView.text = binding.nickNameEditText.text.toString()
                myNameOne?.nickname = binding.nickNameEditText.text.toString()
                invalidateAll()
                nickNameTextView.visibility = View.VISIBLE
                nickNameEditText.visibility = View.GONE
                confirmButton.visibility = View.GONE
            }
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    private fun updateNickName() {

        binding.apply {
            nickNameTextView.visibility = View.GONE
            nickNameEditText.visibility = View.VISIBLE
            confirmButton.visibility = View.VISIBLE
            nickNameEditText.requestFocus()
        }

        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.showSoftInput(binding.nickNameEditText, 0)
    }

    private fun callMe(view: View) {
        val context = view.context

        val intent = Intent(context,ActivityB::class.java)

        context.startActivity(intent)
    }
}