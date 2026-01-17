package com.game.studentsapp
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.game.studentsapp.databinding.StudentRowLayoutBinding
import com.game.studentsapp.models.Student


class StudentsAdapter (
    private var students : List<Student>,
    ): RecyclerView.Adapter<StudentRowViewHolder>(){

    override fun getItemCount(): Int= students.size
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentRowViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding= StudentRowLayoutBinding.inflate(inflater,parent,false)
        return StudentRowViewHolder(binding=binding)




    }
    override fun onBindViewHolder(holder: StudentRowViewHolder, position: Int) {
        holder.bind(students[position],position)
    }

    }

