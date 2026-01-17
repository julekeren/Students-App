package com.game.studentsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.game.studentsapp.databinding.ActivityAddStudentBinding
import com.game.studentsapp.models.Model
import com.game.studentsapp.models.Student

class AddStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddStudentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAddStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.saveStudentButton.setOnClickListener {
            val student = Student(
                name = binding.studentNameEditText.text.toString(),
                id = binding.studentIdEditText.text.toString(),
                phone = binding.studentPhoneEditText.text.toString(),
                address = binding.studentAddressEditText.text.toString(),
                isPresent = binding.addStudentCheckbox.isChecked
            )
            Model.shared.students.add(student)
            finish()
        }

        binding.cancelStudentButton.setOnClickListener {
            finish()
        }
    }
}
