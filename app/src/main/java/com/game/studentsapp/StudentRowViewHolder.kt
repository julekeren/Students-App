package com.game.studentsapp

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import com.game.studentsapp.databinding.StudentRowLayoutBinding
import com.game.studentsapp.models.Student

class StudentRowViewHolder(
    private val binding: StudentRowLayoutBinding
) : RecyclerView.ViewHolder(binding.root) {

    private var student: Student? = null
    private var pos: Int = -1

    init {
        binding.root.setOnClickListener {
            if (pos != -1) {
                val intent = Intent(itemView.context, StudentDetailsActivity::class.java)
                intent.putExtra("STUDENT_POSITION", pos)
                itemView.context.startActivity(intent)
            }
        }

        binding.checkboxView.setOnClickListener { view ->
            student?.isPresent = binding.checkboxView.isChecked
        }
    }

    fun bind(student: Student, position: Int) {
        this.student = student
        this.pos = position

        binding.nameTextView.text = student.name
        binding.idView.text = student.id
        binding.phoneView.text = student.phone
        binding.addressView.text = student.address

        binding.checkboxView.apply {
            isChecked = student.isPresent
            tag = position
        }
    }
}
