package com.example.ageofempire.list


data class EmpireListResponse (
    val total: Int,
    val civilizations: List<Empire>
)