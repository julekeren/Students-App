package com.game.studentsapp

import androidx.recyclerview.widget.RecyclerView
import com.game.studentsapp.databinding.StudentRowLayoutBinding
import com.game.studentsapp.models.Student



class StudentRowViewHolder(
  private val binding: StudentRowLayoutBinding
): RecyclerView.ViewHolder(binding.root) {

    private var student: Student? = null

    init{
            binding.checkboxView.setOnClickListener { view ->
                (view?.tag as Int).let { tag ->

                    student?.isPresent = binding.checkboxView.isChecked
                }

            }
        }



    fun bind (student: Student, position: Int){
        this.student= student

        binding.nameTextView.text= student.name
        binding.idView.text= student.id
        binding.phoneView.text= student.phone
        binding.addressView.text= student.address

        binding.checkboxView.apply {
            isChecked =student.isPresent
            tag=position
        }

    }
}
