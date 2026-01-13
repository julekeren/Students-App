package com.game.studentsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.game.studentsapp.models.Model
import com.game.studentsapp.models.Student




class StudentsListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_students_list)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val students= Model.shared.students
        val listview = findViewById<ListView>(R.id.student_list_activity_list_view)
        listview.adapter = StudentListAdapter(
            students= students
        )


    }
    class StudentListAdapter(
        private val students: List<Student>
    ): BaseAdapter() {
        override fun getCount(): Int =10

        override fun getItem(position: Int): Any? {
            return null
        }

        override fun getItemId(position: Int): Long =0

        override fun getView(
            position: Int,
            convertView: View?,
            parent: ViewGroup?
        ): View? {

            val inflater = LayoutInflater.from(parent?.context)

            var view= convertView
             if (convertView == null) {
              view=  inflater.inflate(R.layout.student_row_layout, parent, false)
                val checkbox = view.findViewById<CheckBox>(R.id.students_row_checkbox)
                checkbox.setOnClickListener { view ->
                    (view?.tag as Int).let { tag ->

                        students[tag].isPresent = checkbox.isChecked
                    }

                }
            }
            val nameTextView = view.findViewById<TextView>(R.id.students_row_name_view)
            val idTextView = view.findViewById<TextView>(R.id.students_row_id_view)
            val phoneTextView = view.findViewById<TextView>(R.id.students_row_phone_view)
            val addressTextView = view.findViewById<TextView>(R.id.students_row_address_view)
            val checkbox = view.findViewById<CheckBox>(R.id.students_row_checkbox)



            nameTextView.text= students[position].name
            idTextView.text= students[position].id
            phoneTextView.text= students[position].phone
            addressTextView.text= students[position].address

            checkbox.apply {
                isChecked =students[position].isPresent
                tag=position
            }






            return view

        }
    }
}