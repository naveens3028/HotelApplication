package com.management.hotelapplication

import android.app.Application
import androidx.room.Room
import com.google.firebase.FirebaseApp
import com.google.firebase.database.FirebaseDatabase
import com.management.hotelapplication.database.AppDatabase
import com.management.hotelapplication.network.KtorClient
import com.management.hotelapplication.ui.home.HomeViewModel
import org.koin.android.ext.android.get
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
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
                viewModelModule,
                networkModule,
                employeeModule,
                firebaseModule
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

    private val networkModule = module {
        single { KtorClient().getHttpClient() }
    }

    private val viewModelModule = module{
        viewModel {
            HomeViewModel()
        }
    }

    private val employeeModule = module{
        single {
            Employee("saro", 35)
        }
    }

    private val firebaseModule = module {
        single {
            FirebaseDatabase.getInstance()
        }
    }


}