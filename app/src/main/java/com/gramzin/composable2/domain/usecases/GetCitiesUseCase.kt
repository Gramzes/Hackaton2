package com.gramzin.composable2.domain.usecases

import androidx.paging.PagingData
import com.gramzin.composable2.domain.model.City
import kotlinx.coroutines.flow.Flow
import ru.rigellab.hb.domain.repository.CityRepository
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(private val cityRep: CityRepository) {
    operator fun invoke(): Flow<PagingData<City>>{
        return cityRep.getCities()
    }
}