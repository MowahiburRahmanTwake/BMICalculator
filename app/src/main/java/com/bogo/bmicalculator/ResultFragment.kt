package com.bogo.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import com.bogo.bmicalculator.databinding.FragmentHomeBinding
import com.bogo.bmicalculator.databinding.FragmentResultBinding
import com.bogo.bmicalculator.viewmodels.BmiViewModel


class ResultFragment : Fragment() {
    private lateinit var viewModel: BmiViewModel
    private lateinit var binding: FragmentResultBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)
        val binding = FragmentResultBinding.inflate(inflater,container,false)

        viewModel.bmi.observe(viewLifecycleOwner,{score->
            binding.resultTV.text = String.format("%.1f",score)
        })

        viewModel.category.observe(viewLifecycleOwner,{category->
            binding.catagoryTV.text = category
        })

        return binding.root

    }

}