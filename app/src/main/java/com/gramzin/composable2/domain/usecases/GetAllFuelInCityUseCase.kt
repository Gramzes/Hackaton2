package com.gramzin.composable2.domain.usecases

import com.gramzin.composable2.domain.model.City
import com.gramzin.composable2.domain.model.Fuel
import ru.rigellab.hb.domain.repository.FuelRepository
import javax.inject.Inject

class GetAllFuelInCityUseCase @Inject constructor(private val fuelRep: FuelRepository) {
    operator fun invoke(city: City): List<Fuel>{
        return fuelRep.getAllFuelInCity(city)
    }
}