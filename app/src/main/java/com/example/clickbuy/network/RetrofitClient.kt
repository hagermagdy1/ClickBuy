package com.example.clickbuy.network

import android.util.Log
import com.example.clickbuy.models.*
import retrofit2.Response


private const val TAG = "RetrofitClient"

class RetrofitClient : RemoteSource {
    private val retrofitHelper = RetrofitHelper.getClient().create(RetrofitService::class.java)
    companion object {
        private var instance: RetrofitClient? = null
        fun getInstance(): RetrofitClient {
            return instance ?: RetrofitClient()
        }
    }
    override suspend fun getAllProducts(
        idCollectionDetails: String,
        categoryTitleComing: String,
        subCategory: String
    ): Response<Products> {
        var response =
            retrofitHelper.getAllProducts(idCollectionDetails, categoryTitleComing, subCategory)
        Log.i(TAG, "getAllProducts code \n ${response.code()}")
        Log.i(TAG, "getAllProducts body \n ${response.body()}")
        return response
    }

    override suspend fun getAllProductsInCollectionByID(collectionID: String): Response<Products> {
        var response = retrofitHelper.getAllProductsInCollectionByID(collectionID)
        Log.i(TAG, "getAllProductsInCollectionByID code \n ${response.code()}")
        Log.i(TAG, "getAllProductsInCollectionByID body\n ${response.body()}")
        return response
    }
    override suspend fun getProductByID(productId: String): Response<ProductParent> {
        var response = retrofitHelper.getProductById(productId)
        return response
    }
    override suspend fun getCategoryIdByTitle(categoryTitle: String): Response<CustomCollections> {
        var response = retrofitHelper.getCategoryIdByTitle(categoryTitle)
        Log.i(TAG, "getCategoryIdByTitle: " + response.code())

        return response
    }
    override suspend fun getAllBrands(): Response<Brands> {
        var response = retrofitHelper.getAllBrands()
        Log.i(TAG, "getAllBrands: ${response.body()}")
        return response
    }


    override suspend fun getAllProductsInSpecificCollectionByIDAndTitle(
        idCollectionDetails: String,
        categoryTitleComingFromHome: String
    ): Response<Products> {
        var response = retrofitHelper.getAllSubCategoriesForSpecificCategoryByIDAndTitle(
            idCollectionDetails,
            categoryTitleComingFromHome
        )
        return response
    }

    override suspend fun getAllSubCategoriesFilterForSpecificCategoryByIDAndTitle(
        idCollectionDetails: String,
        categoryTitleFromFilter: String
    ): Response<Products> {
        var response = retrofitHelper.getAllSubCategoriesFilterForSpecificCategoryByIDAndTitle(
            idCollectionDetails,
            categoryTitleFromFilter
        )
        return response
    }
    override suspend fun getSubCategories(): Response<Products> {
        var response = retrofitHelper.getSubCategories()
        return response
    }
//    override suspend fun getAllOrdersById(id: String): Response<Orders> {
//        var response = retrofitHelper.getAllOrdersById(
//        )
//        return response
//    }
    override suspend fun getAllSubCategoriesForSpecificCategory(idCollectionDetails: String): Response<SubCategories> {
        Log.i(TAG, "getAllSubCategoriesForSpecificCategory: ")
        var response = retrofitHelper.getAllSubCategoriesForSpecificCategory("product_type",idCollectionDetails)
        Log.i(TAG, "getAllSubCategoriesForSpecificCategory: $response")
        return response
    }
}