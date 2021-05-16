package com.example.ageofempire

data class EmpireDetailResponse (
    val name: String,
    val expansion: String,
    val data: Emp
)

data class Emp(
    val title: String
)


