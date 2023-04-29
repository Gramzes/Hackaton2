package com.gramzin.composable2.di.module

import com.gramzin.composable2.data.api.storage.CitiesRemoteStorageImpl
import com.gramzin.composable2.data.storage.CitiesRemoteStorage
import dagger.Binds
import dagger.Module
import ru.rigellab.hb.data.repository.FuelRepositoryImpl
import ru.rigellab.hb.domain.repository.CityRepository
import ru.rigellab.hb.domain.repository.FuelRepository

@Module
interface NetworkBindsModule {

    @Binds
    fun cityRemoteStorageImpl_to_CityRemoteStorage(
        cityRemoteStorageImpl: CitiesRemoteStorageImpl
    ): CitiesRemoteStorage

    @Binds
    fun cityRepositoryImpl_to_CityRepository(
        cityRemoteStorageImpl: CitiesRemoteStorageImpl
    ): CityRepository

    fun citiesRemoteStorageImpl_to_CitiesRemoteStorage(
        cityRemoteStorageImpl: CitiesRemoteStorageImpl
    ): CitiesRemoteStorage

    fun fuelRepositoryImpl_to_FuelRepositoryImpl(
        fuelRepositoryImpl: FuelRepositoryImpl
    ): FuelRepository
}