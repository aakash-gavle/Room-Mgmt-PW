package com.example.roommgmtpw.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.roommgmtpw.R
import com.example.roommgmtpw.adapter.RecyclerViewAdapter
import com.example.roommgmtpw.model.Facilities
import com.example.roommgmtpw.viewmodel.MainActivityViewModel

class FacilitiesFragment : Fragment() {

    private lateinit var recyclerAdapter : RecyclerViewAdapter
  //  private lateinit var exclusionRecyclerAdapter : ExclusionAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_facilities, container, false)

        initViewModel(view)
        initViewModel()
        return view

    }

    private fun initViewModel(view: View) {

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
       recyclerView.layoutManager = LinearLayoutManager(activity)

        val decoration  = DividerItemDecoration(activity, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(decoration)

       recyclerAdapter = RecyclerViewAdapter()
       recyclerView.adapter = recyclerAdapter

   /*     val exclusionRecyclerView = view.findViewById<RecyclerView>(R.id.exclusionRecyclerView)
        exclusionRecyclerView.layoutManager = LinearLayoutManager(activity)
       exclusionRecyclerAdapter = ExclusionAdapter()
       exclusionRecyclerView.adapter = exclusionRecyclerAdapter
        exclusionRecyclerView.addItemDecoration(decoration)*/

    }

    private fun initViewModel() {
        val viewModel  = ViewModelProvider(this)[MainActivityViewModel::class.java]
        viewModel.getRecyclerListObserver().observe(viewLifecycleOwner, Observer<Facilities> {
            if(it != null) {
                recyclerAdapter.setData(it.facilities)
              //  exclusionRecyclerAdapter.setExclusionData(it.exclusion)
            } else {
                Toast.makeText(activity, "Error in getting data", Toast.LENGTH_SHORT).show()
            }
        })

        viewModel.makeApiCall()
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            FacilitiesFragment()
    }

}