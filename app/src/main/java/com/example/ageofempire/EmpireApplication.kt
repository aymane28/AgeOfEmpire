package com.example.ageofempire

import android.app.Application
import android.content.Context

class EmpireApplication : Application (){
    companion object {
        var context: Context? = null
    }

    override fun onCreate(){
        super.onCreate()
        context = this
    }
}