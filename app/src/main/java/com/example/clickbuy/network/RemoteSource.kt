package com.example.clickbuy.network

import com.example.clickbuy.models.*
import retrofit2.Response
import retrofit2.http.Path

interface RemoteSource {

<<<<<<< Updated upstream
=======
    suspend fun getAllProducts(idCollectionDetails : String , categoryTitleComing : String , subCategory : String):  Response<Products>
    suspend fun getAllProductsInCollectionByID(collectionID: String):Response<Products>
    suspend fun getProductByID(productId: String): Response<ProductParent>
    //suspend fun getCustomCollectionsByID(collectionID: String): Response<CustomCollectionElement>
>>>>>>> Stashed changes

    suspend fun getAllProducts(): Response<Products>
    suspend fun getAllProductsInCollectionByID(collectionID: String): Response<Products>
    suspend fun getCategoryIdByTitle(categoryTitle: String): Response<CustomCollections>
    suspend fun getAllBrands(): Response<Brands>
    suspend fun getAllCustomCollections(): Response<CustomCollections>
    suspend fun getAllSubCategoriesForSpecificCategory(collectionID: String): Response<Products>
    suspend fun getAvailableCoupons(): Response<Coupon>
    suspend fun getAllProductsInSpecificCollectionByIDAndTitle(idCollectionDetails : String,categoryTitleComingFromHome : String): Response<Products>
//  suspend fun getCustomCollectionsByID(collectionID: String): Response<CustomCollectionElement>
suspend fun getAllSubCategoriesFilterForSpecificCategoryByIDAndTitle(idCollectionDetails : String , categoryTitleFromFilter : String): Response<Products>
suspend fun getSubCategories(): Response<Products>

}