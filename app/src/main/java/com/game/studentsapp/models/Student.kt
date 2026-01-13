package com.game.studentsapp.models

data class Student(
    val name: String,
    val id: String,
    val phone: String,
    val address: String,
    var isPresent: Boolean,

    )