package com.samoye.inputdisplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.text.method.LinkMovementMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.textfield.TextInputLayout
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linkTextView = findViewById<TextView>(R.id.moreDetails)

        val inputTextView: TextView = findViewById(R.id.inputText)
        val inputTextField: TextInputLayout = findViewById(R.id.inputTextField)

        inputTextField.editText?.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun afterTextChanged(p0: Editable?) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (p0?.isNotEmpty()!!) inputTextField.error = null
            }
        })
        findViewById<Button>(R.id.displayBtn)
                .setOnClickListener {
                    inputTextField.apply {
                        if (editText?.text.isNullOrEmpty()) {
                            error = "Field required"
                            requestFocus()
                        } else {
                            error = null
                            inputTextView.text = editText?.text.toString()
                        }
                    }
                }
    }
}

