package com.gramzin.composable2.data.api.apiService

import com.gramzin.composable2.data.api.model.CityResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface CitiesApiService {
    @GET("database.getCities?country_id=1&access_token=ee68d4d0ee68d4d0ee68d4d005ed7b049aeee68ee68d4d08a25bbd8cd69194de2dee275")
    suspend fun getUserList(@Query("count") count: Int,@Query("count") offset: Int) : CityResponse
}