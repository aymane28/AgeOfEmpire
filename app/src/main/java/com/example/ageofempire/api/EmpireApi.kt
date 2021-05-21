package com.example.ageofempire.api

import com.example.ageofempire.detail.EmpireDetailResponse
import com.example.ageofempire.list.EmpireListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface EmpireApi {
    @GET("civilizations")
    fun getEmpireList(): Call<EmpireListResponse>

    @GET("civilization/{id}")
    fun getEmpireDetail(@Path("id") id: Int): Call<EmpireDetailResponse>
}