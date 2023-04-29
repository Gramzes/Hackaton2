package ru.rigellab.hb.domain.repository

import androidx.paging.PagingData
import com.gramzin.composable2.domain.model.City
import ru.rigellab.hb.domain.model.CityData
import kotlinx.coroutines.flow.*

/**
 * Репозиторий городов
 */
interface CityRepository {
    /**
     * Получение всех городов
     */
    fun getCities(): Flow<PagingData<City>>
}