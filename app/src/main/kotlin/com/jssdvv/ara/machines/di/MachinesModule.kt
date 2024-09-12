package com.jssdvv.ara.machines.di

import android.app.Application
import androidx.room.Room
import com.jssdvv.ara.machines.data.local.MachinesDatabase
import com.jssdvv.ara.machines.data.repositories.ActivityRepositoryImpl
import com.jssdvv.ara.machines.data.repositories.MachineRepositoryImpl
import com.jssdvv.ara.machines.domain.repositories.ActivityRepository
import com.jssdvv.ara.machines.domain.repositories.MachineRepository
import com.jssdvv.ara.machines.domain.usecases.ActivityUseCases
import com.jssdvv.ara.machines.domain.usecases.DeleteActivity
import com.jssdvv.ara.machines.domain.usecases.DeleteMachine
import com.jssdvv.ara.machines.domain.usecases.GetActivities
import com.jssdvv.ara.machines.domain.usecases.GetMachines
import com.jssdvv.ara.machines.domain.usecases.InsertActivity
import com.jssdvv.ara.machines.domain.usecases.InsertMachine
import com.jssdvv.ara.machines.domain.usecases.MachineUseCases
import com.jssdvv.ara.machines.domain.usecases.UpdateActivity
import com.jssdvv.ara.machines.domain.usecases.UpdateMachine
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MachinesModule {
    @Provides
    @Singleton
    fun provideMachineDatabase(context: Application): MachinesDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = MachinesDatabase::class.java,
            name = MachinesDatabase.DATABASE_NAME
        ).createFromAsset("databases/machinesDatabase.db").build()
    }

    @Provides
    @Singleton
    fun provideMachineRepository(database: MachinesDatabase): MachineRepository {
        return MachineRepositoryImpl(database.machineDao)
    }

    @Provides
    @Singleton
    fun provideActivityRepository(database: MachinesDatabase): ActivityRepository {
        return ActivityRepositoryImpl(database.activityDao)
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

    @Provides
    @Singleton
    fun provideActivityUseCases(repository: ActivityRepository): ActivityUseCases {
        return ActivityUseCases(
            getActivities = GetActivities(repository),
            insertActivity = InsertActivity(repository),
            updateActivity = UpdateActivity(repository),
            deleteActivity = DeleteActivity(repository)
        )
    }
}