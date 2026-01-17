package com.game.studentsapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.game.studentsapp.databinding.ActivityStudentDetailsBinding
import com.game.studentsapp.models.Model

class StudentDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityStudentDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val studentPosition = intent.getIntExtra("STUDENT_POSITION", -1)
        if (studentPosition != -1) {
            val student = Model.shared.students[studentPosition]
            
            binding.studentDetailsName.text = student.name
            binding.studentDetailsId.text = student.id
            binding.studentDetailsPhone.text = student.phone
            binding.studentDetailsAddress.text = student.address
            binding.studentDetailsChecked.isChecked = student.isPresent

            binding.studentDetailsChecked.setOnCheckedChangeListener { _, isChecked ->
                student.isPresent = isChecked
            }
        }

        binding.studentDetailsEditButton.setOnClickListener {

        }
    }
}
