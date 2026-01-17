package com.game.studentsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.game.studentsapp.databinding.ActivityStudentDetailsBinding
import com.game.studentsapp.models.Model

class StudentDetailsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityStudentDetailsBinding
    private var studentPosition: Int = -1

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

        studentPosition = intent.getIntExtra("STUDENT_POSITION", -1)
        loadStudentData()

        binding.studentDetailsEditButton.setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("STUDENT_POSITION", studentPosition)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        loadStudentData()
    }

    private fun loadStudentData() {
        if (studentPosition != -1 && studentPosition < Model.shared.students.size) {
            val student = Model.shared.students[studentPosition]
            
            binding.studentDetailsName.text = student.name
            binding.studentDetailsId.text = student.id
            binding.studentDetailsPhone.text = student.phone
            binding.studentDetailsAddress.text = student.address
            binding.studentDetailsChecked.isChecked = student.isPresent

            binding.studentDetailsChecked.setOnCheckedChangeListener { _, isChecked ->
                student.isPresent = isChecked
            }
        } else if (studentPosition >= Model.shared.students.size) {
            finish()
        }
    }
}
