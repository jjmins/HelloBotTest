package com.jjmin.hellobottest.di

import com.jjmin.hellobottest.API
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModules{
    var url = "https://api.github.com/repos/google/dagger/"
    val networkModules = module {
        single {
            Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build()
                .create(API::class.java)
        }
    }
}