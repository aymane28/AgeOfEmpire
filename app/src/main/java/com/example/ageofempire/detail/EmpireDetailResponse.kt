package com.example.ageofempire.detail

data class EmpireDetailResponse (
    val name: String,
    val expansion: String,
    val army_type: String,
    val team_bonus: String,
    val data: Emp
)

data class Emp(
    val title: String
)


