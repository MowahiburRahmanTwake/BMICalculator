package com.bogo.bmicalculator.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bogo.bmicalculator.ResultFragment

class BmiViewModel:ViewModel() {
    var bmi: MutableLiveData<Double> = MutableLiveData()
    var category: MutableLiveData<String> = MutableLiveData()
    fun calculateBtn(weight: Double, height: Double){
        bmi.value = weight / (height*height)


        category.value =when(String.format("%.1f",bmi.value).toDouble()){
            in 0.0 .. 18.4 -> BmiViewModel.Underweight
            in 18.5 .. 24.9 -> BmiViewModel.Normal
            in 25.0 .. 29.9 -> BmiViewModel.Overerweight
            in 30.0 .. 34.9 -> BmiViewModel.Obese1
            in 35.0 .. 39.9 -> BmiViewModel.Obese2
            else -> BmiViewModel.Obese3
        }
    }
    companion object{
        val Underweight = "UNDERWEIGHT"
        val Overerweight = "OVEREWEIGHT"
        val Normal = "NORMAL"
        val Obese1 = "OBESE1"
        val Obese2 = "OBESE2"
        val Obese3 = "OBESE3"

    }
}