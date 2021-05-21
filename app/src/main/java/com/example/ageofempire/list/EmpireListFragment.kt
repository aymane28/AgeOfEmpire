package com.example.ageofempire.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.AgeofEmpire.R
import com.example.ageofempire.model.EmpireError
import com.example.ageofempire.model.EmpireListViewModel
import com.example.ageofempire.model.EmpireLoader
import com.example.ageofempire.model.EmpireSuccess


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class EmpireListFragment : Fragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var loader: ProgressBar
    private lateinit var textViewError: TextView
    private val adapter= EmpireAdapter(listOf(), ::onClickedEmpire)
    private val viewModel: EmpireListViewModel by viewModels()

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empire_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView=view.findViewById(R.id.empire_recyclerview)
        loader= view.findViewById(R.id.empire_loader)
        textViewError= view.findViewById(R.id.empire_error)

        recyclerView.apply {
            layoutManager= LinearLayoutManager(context)
            adapter=this@EmpireListFragment.adapter
        }

        viewModel.empireList.observe(viewLifecycleOwner, Observer { empireModel ->
            loader.isVisible = empireModel is EmpireLoader
            textViewError.isVisible = empireModel is EmpireError
            if(empireModel is EmpireSuccess){
                adapter.updateList(empireModel.empireList)
            }
        })
    }

    private fun onClickedEmpire(id: Int) {
        findNavController().navigate(R.id.navigateToEmpireDetailFragment, bundleOf("pokemonId" to (id+1)))

    }
}