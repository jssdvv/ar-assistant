package com.jssdvv.ar_maintassist.machines.di

import android.app.Application
import androidx.room.Room
import com.jssdvv.ar_maintassist.machines.data.local.MachineDatabase
import com.jssdvv.ar_maintassist.machines.data.repositories.MachineRepositoryImpl
import com.jssdvv.ar_maintassist.machines.domain.repositories.MachineRepository
import com.jssdvv.ar_maintassist.machines.domain.usecases.DeleteMachine
import com.jssdvv.ar_maintassist.machines.domain.usecases.GetMachines
import com.jssdvv.ar_maintassist.machines.domain.usecases.InsertMachine
import com.jssdvv.ar_maintassist.machines.domain.usecases.MachineUseCases
import com.jssdvv.ar_maintassist.machines.domain.usecases.UpdateMachine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MachineModule {
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
        return MachineRepositoryImpl(database.dao)
    }

    @Provides
    @Singleton
    fun provideMachineUseCases(repository: MachineRepository): MachineUseCases {
        return MachineUseCases(
            getMachines = GetMachines(repository),
            insertMachine = InsertMachine(repository),
            updateMachine = UpdateMachine(repository),
            deleteMachine = DeleteMachine(repository)
        )
    }
}