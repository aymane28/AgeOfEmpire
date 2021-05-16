package com.example.ageofempire

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface EmpireApi {
    @GET("civilizations")
    fun getEmpireList(): Call<EmpireListResponse>

    @GET("civilization/{id}")
    fun getPokemonDetail(@Path("id") id: Int): Call<EmpireDetailResponse>
}