package com.jjmin.hellobottest

import android.app.Application
import com.jjmin.hellobottest.di.NetworkModules
import com.jjmin.hellobottest.di.PresenterModules
import com.jjmin.hellobottest.di.RepositoryModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApplication)
            modules(
                RepositoryModules.issueModules,
                NetworkModules.networkModules,
                PresenterModules.mainModule,
                PresenterModules.detailModule
            )
        }

    }
}