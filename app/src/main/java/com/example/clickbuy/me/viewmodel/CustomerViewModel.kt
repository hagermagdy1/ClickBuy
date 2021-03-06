package com.example.clickbuy.me.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clickbuy.models.Customer
import com.example.clickbuy.models.CustomerTest
import com.example.clickbuy.models.CustomersTest
import com.example.clickbuy.models.RepositoryInterface
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

const val TAG = "CustomerViewModel"

class CustomerViewModel(iRepo: RepositoryInterface) : ViewModel() {
    private val _iRepo: RepositoryInterface = iRepo
    private var _customerDetails = MutableLiveData<List<Customer>>()
    val customerDetails: LiveData<List<Customer>> = _customerDetails

    private var _updatedCustomerDetails = MutableLiveData<CustomerTest>()
    val updatedCustomerDetails: LiveData<CustomerTest> = _updatedCustomerDetails

    fun getCustomerDetails(email: String) {
        viewModelScope.launch {
            val response = _iRepo.getCustomerDetails(email)
            withContext(Dispatchers.Main) {
                if (response.code() == 200 && !response.body()?.customers.isNullOrEmpty()) {
                    _customerDetails.postValue(response.body()!!.customers)
                    Log.i(TAG, "getCustomerDetails: " + response.body())
                } else {
                    Log.i(TAG, "getCustomerDetails: size-----> " + response.body()?.customers?.size)
                    Log.i(TAG, "getCustomerDetails: response.body()-----> " + response.body())
                    _customerDetails.postValue(emptyList())
                }

            }
        }

    }


    fun updateCustomerDetailsTest(customer: CustomersTest) {
        viewModelScope.launch {
            val response = _iRepo.updateCustomerDetailsTest(customer)
            withContext(Dispatchers.Main) {
                Log.i(TAG, "updateCustomerDetailsTest: response.code()------------> " + response.code())
                if (response.isSuccessful) {
                    _updatedCustomerDetails.postValue(response.body()!!.customer)
                    Log.i(TAG, "updateCustomerDetailsTest: " + response.body())
                }

            }
        }

    }


    fun deleteSavedSettings() {
        viewModelScope.launch {
            _iRepo.deleteSavedSettings()
        }
    }

    init {
        Log.i(TAG, "init: ")
    }


    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "onCleared: ")
    }


}