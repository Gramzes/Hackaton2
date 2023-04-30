package com.gramzin.composable2.di.module

import com.gramzin.composable2.data.api.storage.CitiesRemoteStorageImpl
import com.gramzin.composable2.data.storage.CitiesRemoteStorage
import dagger.Binds
import dagger.Module
import ru.rigellab.hb.data.repository.CityRepositoryImpl
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
        cityRepositoryImpl: CityRepositoryImpl
    ): CityRepository

    @Binds
    fun fuelRepositoryImpl_to_FuelRepository(
        fuelRepositoryImpl: FuelRepositoryImpl
    ): FuelRepository
}