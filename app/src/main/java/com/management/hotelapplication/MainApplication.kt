package com.management.hotelapplication

import android.app.Application
import androidx.room.Room
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.ui.home.HomeViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.context.GlobalContext.startKoin
import org.koin.dsl.module

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MainApplication)
            modules(
                databaseModule,
                viewModelModule
            )
        }


    }

    private val databaseModule = module {

        fun provideDatabase(application: Application): AppDatabase {
            return Room.databaseBuilder(application, AppDatabase::class.java, "hotel_data")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build()
        }

        single { provideDatabase(androidApplication()) }
    }

    private val viewModelModule = module{
        viewModel {
            HomeViewModel()
        }
    }

}