package com.bogo.bmicalculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.bogo.bmicalculator.databinding.FragmentHomeBinding
import com.bogo.bmicalculator.viewmodels.BmiViewModel

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: BmiViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(requireActivity()).get(BmiViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater,container,false)



        binding.calculateBtn.setOnClickListener {
            val weight = binding.weightinputEt.text.toString().toDouble()
            val height = binding.heighatinputEt.text.toString().toDouble()
            viewModel.calculateBtn(weight,height)

//            Toast.makeText(activity, bmi.toString(), Toast.LENGTH_SHORT).show()

            findNavController().navigate(R.id.result_action)
        }
        return binding.root
    }

}