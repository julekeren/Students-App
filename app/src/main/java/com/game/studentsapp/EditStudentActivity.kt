package com.game.studentsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.game.studentsapp.databinding.ActivityEditStudentBinding
import com.game.studentsapp.models.Model
import com.game.studentsapp.models.Student

class EditStudentActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditStudentBinding
    private var studentPosition: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityEditStudentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "Edit student details"

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        studentPosition = intent.getIntExtra("STUDENT_POSITION", -1)
        if (studentPosition != -1) {
            val student = Model.shared.students[studentPosition]
            binding.editStudentName.setText(student.name)
            binding.editStudentId.setText(student.id)
            binding.editStudentPhone.setText(student.phone)
            binding.editStudentAddress.setText(student.address)
            binding.editStudentChecked.isChecked = student.isPresent
        }

        binding.editStudentSaveButton.setOnClickListener {
            saveChanges()
        }

        binding.editStudentDeleteButton.setOnClickListener {
            deleteStudent()
        }

        binding.editStudentCancelButton.setOnClickListener {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun saveChanges() {
        if (studentPosition != -1) {
            val updatedStudent = Student(
                name = binding.editStudentName.text.toString(),
                id = binding.editStudentId.text.toString(),
                phone = binding.editStudentPhone.text.toString(),
                address = binding.editStudentAddress.text.toString(),
                isPresent = binding.editStudentChecked.isChecked
            )
            Model.shared.students[studentPosition] = updatedStudent
            finish()
        }
    }

    private fun deleteStudent() {
        if (studentPosition != -1) {
            Model.shared.students.removeAt(studentPosition)
            val intent = Intent(this, StudentsRecyclerViewActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}
