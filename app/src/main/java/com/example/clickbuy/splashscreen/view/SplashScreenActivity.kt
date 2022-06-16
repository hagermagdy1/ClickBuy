package com.example.clickbuy.splashscreen.view

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.View
import android.view.Window
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.clickbuy.R
import com.example.clickbuy.mainscreen.view.MainActivity
import com.example.clickbuy.models.Favorite
import com.example.clickbuy.models.Repository
import com.example.clickbuy.network.RetrofitClient
import com.example.clickbuy.productdetails.viewmodel.ProductDetailsViewModel
import com.example.clickbuy.productdetails.viewmodel.ProductDetailsViewModelFactory
import com.example.clickbuy.splashscreen.viewmodel.SplashViewModel
import com.example.clickbuy.splashscreen.viewmodel.SplashViewModelFactory
import com.example.clickbuy.util.ConnectionLiveData
import com.example.clickbuy.util.ConstantsValue
import com.example.clickbuy.util.isNetworkAvailable
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


private const val TAG = "SplashScreenActivity"

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var logo: ImageView
    private lateinit var title: TextView
    private lateinit var description: TextView
    private lateinit var topAnim: Animation
    private lateinit var bottomAnim: Animation
    private lateinit var modelFactory: SplashViewModelFactory
    private lateinit var viewModel: SplashViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.activity_splash_screen)

        initUI()
        initViewModel()

        /*connectionLiveData = ConnectionLiveData(this)

        connectionLiveData.observe(this) {
            Log.i(TAG, "onCreate: it----------------> $it")
            Log.i(TAG, "onCreate: -----------------> " + connectionLiveData.value)
        }

        Log.i(TAG, "onCreate: -----------------> " + connectionLiveData.value)*/
        ConnectionLiveData.getInstance(this).observe(this) {

        }

        Log.i(TAG, "onCreate: -----------------> " + ConnectionLiveData.getInstance(this).value)

        Log.i(TAG, "onCreate: -----------------> " + ConnectionLiveData(this).value)


        CoroutineScope(Dispatchers.Main).launch {
            delay(2000)
            if (ConnectionLiveData.getInstance(this@SplashScreenActivity).value == true) {
                startActivity(Intent(this@SplashScreenActivity, MainActivity::class.java))
                viewModel.setupConstantsValue()
            } else {
                showSnackbar()
            }
        }

    }

    private fun initUI() {
        title = findViewById(R.id.title_textView)
        logo = findViewById(R.id.logo_imageView)
        description = findViewById(R.id.description_textView)

        topAnim = AnimationUtils.loadAnimation(this, R.anim.splash_screen_top_animation)
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.splash_screen_bottom_animation)

        title.animation = topAnim
        logo.animation = bottomAnim
        description.animation = bottomAnim
    }

    private fun initViewModel() {
        modelFactory = SplashViewModelFactory(
            Repository.getInstance(
                RetrofitClient.getInstance(),
                this
            )
        )
        viewModel = ViewModelProvider(this, modelFactory)
            .get(SplashViewModel::class.java)

        //   viewModel.setupConstantsValue()

    }

    private fun showSnackbar() {
        val snackBar = Snackbar.make(
            findViewById(R.id.splashScreenActivity_ConstraintLayout),
            getString(R.string.no_internet),
            Snackbar.LENGTH_INDEFINITE
        ).setActionTextColor(Color.WHITE)

        snackBar.setAction(getString(R.string.enable_connection)) {
            startActivity(Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY))
        }
        snackBar.view.setBackgroundColor(Color.RED)
        snackBar.show()
    }


}