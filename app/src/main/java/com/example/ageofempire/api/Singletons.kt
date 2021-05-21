package com.example.ageofempire.api

import com.example.ageofempire.view.EmpireApplication.Companion.context
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File


class Singletons{
    companion object{
        var cache = Cache(File(context?.cacheDir, "responses"), 10 * 1024* 1024)
        val okHttpClient: OkHttpClient = OkHttpClient().newBuilder()
                .cache(cache)
                .build()

   val empireApi: EmpireApi = Retrofit.Builder()
                .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
           .client(okHttpClient)
                .build()
                .create(EmpireApi::class.java)


    }
}
