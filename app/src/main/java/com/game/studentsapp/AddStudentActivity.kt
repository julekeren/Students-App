package com.game.studentsapp

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat



class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_add_student)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val addStudentButton: Button = findViewById<Button>(R.id.save_student_button)
        val cancelButton: Button = findViewById<Button>(R.id.cancel_student_button)
        val studentNameEditText: EditText = findViewById<EditText>(R.id.student_name_edit_text)
        val studentIdEditText: EditText = findViewById<EditText>(R.id.student_id_edit_text)
        val studentPhoneEditText: EditText = findViewById<EditText>(R.id.student_phone_edit_text)
        val studentAddressEditText: EditText = findViewById<EditText>(R.id.student_address_edit_text)
        val saveStatusTextView: TextView = findViewById<TextView>(R.id.add_student_save_status_text_view)
        val addStudentCheckbox: CheckBox = findViewById<CheckBox>(R.id.add_student_checkbox)



        cancelButton.setOnClickListener {
            finish()
         }
        addStudentButton.setOnClickListener {
            val studentName = studentNameEditText.text.toString()
            val studentId = studentIdEditText.text.toString()
            val studentPhone = studentPhoneEditText.text.toString()
            val studentAddress = studentAddressEditText.text.toString()
            val studentChecked = addStudentCheckbox.isChecked

            saveStatusTextView.text="Student saved: Name =$studentName ID=$studentId"
            studentNameEditText.text.clear()
            studentIdEditText.text.clear()
            studentPhoneEditText.text.clear()
            studentAddressEditText.text.clear()

        }


    }
}