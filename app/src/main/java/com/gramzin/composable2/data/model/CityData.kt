package ru.rigellab.hb.domain.model

import com.gramzin.composable2.domain.model.City


/**
 * Город
 * @property id id города в системе
 * @property name назвние города
 */
data class CityData(val id: Int, val name: String)

fun CityData.toDomain(): City {
    return City(name)
}