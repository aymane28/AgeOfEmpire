package com.example.ageofempire

sealed class EmpireModel

data class EmpireSuccess(val empireList: List<Empire>): EmpireModel()

object EmpireLoader : EmpireModel()
object EmpireError : EmpireModel()