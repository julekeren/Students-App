package com.game.studentsapp.models

class Model private constructor(){
    val students = mutableListOf<Student>()
    init {
        for(i in 1..20) {
            val student = Student(
                name = "student $i",
                id = "id ${1000 + i}",
                phone = "phone $i",
                address = "address $i",
            false
            )
            students.add(student)
        }
    }

    companion object{
        val shared= Model()

    }
}