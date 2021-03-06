package com.example.clickbuy.mainscreen.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import com.etebarian.meowbottomnavigation.MeowBottomNavigation
import com.example.clickbuy.R
import com.example.clickbuy.category.view.CategoryFragment
import com.example.clickbuy.databinding.ActivityMainBinding
import com.example.clickbuy.home.view.HomeFragment
import com.example.clickbuy.me.view.logged.MeFragment
import com.example.clickbuy.me.view.guest.GuestFragment
import com.example.clickbuy.mainscreen.viewmodel.MainActivityViewModel
import com.example.clickbuy.mainscreen.viewmodel.MainActivityViewModelFactory
import com.example.clickbuy.models.Repository
import com.example.clickbuy.network.RetrofitClient
import com.example.clickbuy.util.ConnectionLiveData
import com.example.clickbuy.util.ConstantsValue

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {

    private lateinit var viewModelFactory: MainActivityViewModelFactory
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var meo: MeowBottomNavigation
    private var fragmentShow: Int = 0
    private val ID_HOME = 1
    private val ID_CATEGORY = 2
    private val ID_PROFILE = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()

        ConnectionLiveData.getInstance(this).observe(this) {
            Log.i(TAG, "observe on connection: ----------------> $it")
            if (it) {
                viewModel.setupConstantsValue()
                viewModel.getQualifiedValueCurrency(ConstantsValue.to)
            } else {
                Log.i(TAG, "onCreate: no internet")
            }
        }

        replaceFragment(HomeFragment())

        viewModel.currencyConverter.observe(this) {
            ConstantsValue.currencyValue = it.result
            Log.i(TAG, "onCreate: currencyValue ----------> " + ConstantsValue.currencyValue)
            Log.i(TAG, "onCreate: it.result --------------> " + it.result)
        }

        meo = binding.bottomNav

        meo.add(MeowBottomNavigation.Model(ID_HOME, R.drawable.home))
        meo.add(MeowBottomNavigation.Model(ID_CATEGORY, R.drawable.categories))
        meo.add(MeowBottomNavigation.Model(ID_PROFILE, R.drawable.profile))

        meo.setOnClickMenuListener {
            when (it.id) {
                ID_HOME -> {
                    fragmentShow = ID_HOME
                    replaceFragment(HomeFragment())
                }
                ID_CATEGORY -> {
                    fragmentShow = ID_CATEGORY
                    replaceFragment(CategoryFragment())
                }
                ID_PROFILE -> {
                    fragmentShow = ID_PROFILE
                    if (ConstantsValue.email.isNotEmpty())
                        replaceFragment(MeFragment())
                    else
                        replaceFragment(GuestFragment())
                }
            }
        }
        meo.setOnShowListener { item ->
            fragmentShow = item.id
        }
        meo.show(ID_HOME, true)
    }

    private fun initViewModel() {
        viewModelFactory = MainActivityViewModelFactory(
            Repository.getInstance(
                RetrofitClient.getInstance(),
                this
            )
        )
        viewModel =
            ViewModelProvider(this, viewModelFactory).get(MainActivityViewModel::class.java)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
    }

    fun updateCurrency() {
        Log.i(TAG, "updateCurrency: ")
        viewModel.getQualifiedValueCurrency(ConstantsValue.to)
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) supportFragmentManager.popBackStack() else finish() // Finish the activity
    }
}
