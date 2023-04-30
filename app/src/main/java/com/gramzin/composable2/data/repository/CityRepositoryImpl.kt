package ru.rigellab.hb.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import com.gramzin.composable2.data.api.ApiUtils
import com.gramzin.composable2.data.paging.CityPagingSource
import com.gramzin.composable2.domain.model.City
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.transform
import ru.rigellab.hb.domain.model.CityData
import ru.rigellab.hb.domain.model.toDomain
import ru.rigellab.hb.domain.repository.CityRepository
import javax.inject.Inject

class CityRepositoryImpl @Inject constructor(
    private val cityPagingSourceFactory: CityPagingSource.Factory): CityRepository {
    override fun getCities(): Flow<PagingData<City>> {
        return Pager(PagingConfig(pageSize = ApiUtils.PAGE_SIZE,
            initialLoadSize = ApiUtils.PAGE_SIZE)) {
            cityPagingSourceFactory.create()
        }.flow.toDomain()
    }
}

fun Flow<PagingData<CityData>>.toDomain(): Flow<PagingData<City>> {
    return transform { value ->
        emit(value.map {
            it.toDomain()
        })
    }
}