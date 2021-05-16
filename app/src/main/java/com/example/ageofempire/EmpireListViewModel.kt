package com.example.ageofempire

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EmpireListViewModel : ViewModel(){
     val empireList: MutableLiveData<EmpireModel> = MutableLiveData()

    init{
        callApi()
    }

    private fun callApi() {
        empireList.value = EmpireLoader

        Singletons.empireApi.getEmpireList().enqueue(object : Callback<EmpireListResponse> {
            override fun onResponse(call: Call<EmpireListResponse>, response: Response<EmpireListResponse>) {
                if (response.isSuccessful && response.body() != null) {
                    val empireResponse = response.body()!!
                    empireList.value = EmpireSuccess(empireResponse.civilizations)
                } else {
                    empireList.value = EmpireError
                }
            }

            override fun onFailure(call: Call<EmpireListResponse>, t: Throwable) {
                empireList.value = EmpireError

            }
        })
    }

}