package com.example.ageofempire

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.AgeofEmpire.R
import retrofit2.Call
import retrofit2.Response


class EmpireDetailFragment : Fragment() {

    private lateinit var textViewName: TextView
    private lateinit var textViewDetail: TextView
    private lateinit var textViewDetail2: TextView
    private lateinit var textViewDetail3: TextView
    private lateinit var textViewDetail4: Button

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empire_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textViewName = view.findViewById(R.id.empire_detail_name)
        textViewDetail = view.findViewById(R.id.empire_detail)
        textViewDetail2 = view.findViewById(R.id.empire_detail2)
        textViewDetail3 = view.findViewById(R.id.empire_detail3)
        callApi()
    }

        private fun callApi() {
            val id = arguments?.getInt("pokemonId") ?: -1
            Singletons.empireApi.getEmpireDetail(id).enqueue(object : retrofit2.Callback<EmpireDetailResponse> {
                override fun onResponse(call: Call<EmpireDetailResponse>,
                                        response: Response<EmpireDetailResponse>) {
                    if (response.isSuccessful && response.body() != null) {
                        textViewName.text = response.body()!!.name
                        textViewDetail.text = response.body()!!.expansion
                        textViewDetail2.text = response.body()!!.army_type
                        textViewDetail3.text = response.body()!!.team_bonus
                    }
                }

                override fun onFailure(call: Call<EmpireDetailResponse>,
                                       t: Throwable) {
                    TODO("Not yet implemented")
                }
            })
        }

}


