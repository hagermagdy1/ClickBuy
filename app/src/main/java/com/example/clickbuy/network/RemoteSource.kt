package com.example.clickbuy.network

import com.example.clickbuy.models.*
import retrofit2.Response

interface RemoteSource {

    suspend fun getAllProducts():  Response<Products>
    suspend fun getAllProductsInCollectionByID(collectionID: String):Response<Products>
    suspend fun getCustomCollectionsByID(collectionID: String): Response<CustomCollectionElement>
    suspend fun getAllCustomCollections():  Response<CustomCollections>

    suspend fun getAvailableCoupons():  Response<Coupon>
    suspend fun getAvailableAds():  Response<Ads>
    suspend fun getAllSubCategoriesForSpecificCategory(collectionID: String): Response<Products>
}