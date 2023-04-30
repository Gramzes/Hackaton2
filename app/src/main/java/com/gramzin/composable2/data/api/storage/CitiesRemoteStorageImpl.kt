package com.gramzin.composable2.data.api.storage

import com.gramzin.composable2.data.api.apiService.CitiesApiService
import com.gramzin.composable2.data.api.model.CityResponse
import com.gramzin.composable2.data.api.model.toData
import com.gramzin.composable2.data.storage.CitiesRemoteStorage
import com.gramzin.composable2.domain.model.City
import ru.rigellab.hb.domain.model.CityData
import javax.inject.Inject

class CitiesRemoteStorageImpl @Inject constructor(private val citiesApiService: CitiesApiService)
    : CitiesRemoteStorage {
    override suspend fun getCities(count: Int, offset: Int): List<CityData> {
        var a: List<CityData> = listOf()
        try {
           a = citiesApiService.getUserList(count, offset).toData()
            val b =1
        }catch (e: Exception){
            e.stackTrace
        }
        return a
    }
}