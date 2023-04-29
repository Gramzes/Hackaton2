package com.gramzin.composable2.domain.usecases

import com.gramzin.composable2.domain.model.City
import com.gramzin.composable2.domain.model.Fuel
import com.gramzin.composable2.domain.model.FuelHistory
import com.gramzin.composable2.domain.model.Period
import ru.rigellab.hb.domain.repository.FuelRepository
import javax.inject.Inject

class GetFuelHistoryUseCase @Inject constructor(private val fuelRep: FuelRepository) {
    operator fun invoke(city: City, fuel: Fuel, period: Period): List<FuelHistory>{
        return fuelRep.getFuelHistory(city, fuel, period)
    }
}