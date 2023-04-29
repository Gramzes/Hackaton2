package com.gramzin.composable2.data.storage

import ru.rigellab.hb.domain.model.CityData

interface CitiesRemoteStorage {
    suspend fun getCities(count: Int, offset: Int): List<CityData>
}