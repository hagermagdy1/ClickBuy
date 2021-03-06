package com.example.clickbuy.authentication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.clickbuy.authentication.viewmodel.AuthenticationViewModel
import com.example.clickbuy.authentication.viewmodel.AuthenticationViewModelFactory
import com.example.clickbuy.databinding.ActivityAuthenticationBinding
import com.example.clickbuy.models.Repository
import com.example.clickbuy.network.RetrofitClient

class AuthenticationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthenticationBinding
    lateinit var viewModel: AuthenticationViewModel
    private lateinit var modelFactory: AuthenticationViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthenticationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupViewModel()
    }

    private fun setupViewModel() {
        modelFactory = AuthenticationViewModelFactory(
            Repository.getInstance(
                RetrofitClient.getInstance(),
                this
            )
        )
        viewModel = ViewModelProvider(this, modelFactory)
            .get(AuthenticationViewModel::class.java)
    }
}