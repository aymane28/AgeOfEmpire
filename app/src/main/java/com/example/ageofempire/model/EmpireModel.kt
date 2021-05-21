package com.example.ageofempire.model

import com.example.ageofempire.list.Empire

sealed class EmpireModel

data class EmpireSuccess(val empireList: List<Empire>): EmpireModel()

object EmpireLoader : EmpireModel()
object EmpireError : EmpireModel()