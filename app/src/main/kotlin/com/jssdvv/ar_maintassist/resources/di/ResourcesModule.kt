package com.jssdvv.ar_maintassist.resources.di

import android.app.Application
import androidx.room.Room
import com.jssdvv.ar_maintassist.resources.data.local.MachineDatabase
import com.jssdvv.ar_maintassist.resources.data.repository.MachineRepositoryImpl
import com.jssdvv.ar_maintassist.resources.domain.repository.MachineRepository
import com.jssdvv.ar_maintassist.resources.domain.usecases.DeleteMachine
import com.jssdvv.ar_maintassist.resources.domain.usecases.GetMachines
import com.jssdvv.ar_maintassist.resources.domain.usecases.MachineUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ResourcesModule {
    @Provides
    @Singleton
    fun provideMachineDatabase(context: Application): MachineDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = MachineDatabase::class.java,
            name = MachineDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideMachineRepository(database: MachineDatabase): MachineRepository {
        return MachineRepositoryImpl(database.machineDao)
    }

    @Provides
    @Singleton
    fun provideMachineUseCases(repository: MachineRepository): MachineUseCases {
        return MachineUseCases(
            getMachines = GetMachines(repository),
            deleteMachine = DeleteMachine(repository)
        )
    }
}