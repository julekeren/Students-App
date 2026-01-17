package com.game.studentsapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.game.studentsapp.databinding.ActivityStudentsRecyclerViewBinding
import com.game.studentsapp.models.Model

class StudentsRecyclerViewActivity : AppCompatActivity() {
    private var binding: ActivityStudentsRecyclerViewBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityStudentsRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        
        setSupportActionBar(binding?.toolbar)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val layout = LinearLayoutManager(this)
        binding?.recyclerView?.layoutManager = layout
        binding?.recyclerView?.setHasFixedSize(true)
        val adapter = StudentsAdapter(Model.shared.students)
        binding?.recyclerView?.adapter = adapter

        binding?.addStudentFab?.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        binding?.recyclerView?.adapter?.notifyDataSetChanged()
    }
}
