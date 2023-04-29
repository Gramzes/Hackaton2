package ru.rigellab.hb.domain.repository

import com.gramzin.composable2.domain.model.City
import com.gramzin.composable2.domain.model.Fuel
import com.gramzin.composable2.domain.model.FuelHistory
import com.gramzin.composable2.domain.model.Period

/**
 * Репозиторий топлива
 */
interface FuelRepository {

    /**
     * Получение всех типов топлива в городе
     * @param cityId id города
     */
    fun getAllFuelInCity(city: City): List<Fuel>

    /**
     * Получение истории изменения цены топлива
     * @param cityId id города
     * @param fuelId id топлива
     * @param start дата начала периода (включительно)
     * @param end дата окончания периода (включительно)
     */
    fun getFuelHistory(city: City, fuel: Fuel, period: Period): List<FuelHistory>
}