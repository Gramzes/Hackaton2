package com.gramzin.composable2.data.api.storage

import com.gramzin.composable2.data.api.apiService.CitiesApiService
import com.gramzin.composable2.data.api.model.toData
import com.gramzin.composable2.data.storage.CitiesRemoteStorage
import ru.rigellab.hb.domain.model.CityData
import javax.inject.Inject

class CitiesRemoteStorageImpl @Inject constructor(private val citiesApiService: CitiesApiService)
    : CitiesRemoteStorage {
    override suspend fun getCities(count: Int, offset: Int): List<CityData> {
        return citiesApiService.getUserList(count, offset).toData()
    }
}