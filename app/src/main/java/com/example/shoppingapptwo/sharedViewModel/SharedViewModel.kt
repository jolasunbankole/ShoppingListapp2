package com.example.shoppingapptwo.sharedViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel: ViewModel() {


    private val _groceryList = MutableLiveData<Int>()
    val groceryList: LiveData<Int> = _groceryList


    fun setList(setTheList:Int) {
        _groceryList.value = setTheList
    }






}






