package com.example.clickbuy.models

import android.content.Context
import android.util.Log
import com.example.clickbuy.network.RemoteSource
import com.example.clickbuy.network.RetrofitClient
import retrofit2.Response


private const val TAG = "Repository"

class Repository private constructor(
    var remoteSource: RemoteSource,
    var context: Context
) : RepositoryInterface {


    companion object {
        private var instance: Repository? = null
        fun getInstance(
            remoteSource: RetrofitClient, context: Context
        ): Repository {

            return instance ?: Repository(remoteSource, context)
        }
    }

    init {
        this.remoteSource = remoteSource
    }

    override suspend fun getAllBrands(): Response<Brands> {
        Log.i(TAG, "getAllBrands: ")
        return remoteSource.getAllBrands()

    }

    override suspend fun getAllBrandsDetais(id : String): Response<Products> {
        Log.i(TAG, "getAllBrandsDetails: ")
        return remoteSource.getAllProductsInCollectionByID(id)
    }

    override suspend fun getSalesId(): Response<CustomCollections> {
        Log.i(TAG, "getAllCustomCollections: ")
        return remoteSource.getAllCustomCollections()
    }

}