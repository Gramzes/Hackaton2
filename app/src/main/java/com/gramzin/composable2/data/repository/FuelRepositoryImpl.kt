package ru.rigellab.hb.data.repository

import com.gramzin.composable2.domain.model.City
import com.gramzin.composable2.domain.model.Fuel
import com.gramzin.composable2.domain.model.FuelHistory
import com.gramzin.composable2.domain.model.Period
import kotlinx.coroutines.flow.asFlow
import ru.rigellab.hb.domain.model.FuelData
import ru.rigellab.hb.domain.repository.FuelRepository
import java.util.Date
import javax.inject.Inject

class FuelRepositoryImpl @Inject constructor() : FuelRepository {

    override fun getAllFuelInCity(city: City): List<Fuel> {
        if (city.name == "Москва")
            return listOf(Fuel(92, "92"), Fuel(98, "98"), Fuel(100, "100"))
        else if (city.name == "Санкт-Петербург")
            return listOf(Fuel(92, "92"), Fuel(98, "98"), Fuel(100, "100"))
        return listOf(Fuel(92, "92"), Fuel(98, "98"), Fuel(100, "100"))
    }

    override fun getFuelHistory(city: City, fuel: Fuel, period: Period): List<FuelHistory> {
        if (city.name == "Москва" && fuel.id == 92)
            return listOf(FuelHistory(period.startDate, 50),
                FuelHistory(Date((period.startDate.time - period.endDate.time)/2), 52),
                FuelHistory(period.endDate, 50)
            )
        if (city.name == "Москва" && fuel.id == 98)
            return listOf(FuelHistory(period.startDate, 60),
                FuelHistory(Date((period.startDate.time - period.endDate.time)/2), 64),
                FuelHistory(period.endDate, 100)
            )
        return listOf(FuelHistory(period.startDate, 40),
                FuelHistory(Date((period.startDate.time - period.endDate.time)/2), 46),
                FuelHistory(period.endDate, 50)
            )
    }
}