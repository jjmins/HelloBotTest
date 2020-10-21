package com.jjmin.hellobottest.di

import com.jjmin.hellobottest.ui.detail.DetailContract
import com.jjmin.hellobottest.ui.detail.DetailPresenter
import com.jjmin.hellobottest.ui.main.MainContract
import com.jjmin.hellobottest.ui.main.MainPresenter
import org.koin.dsl.module

object PresenterModules {

    val mainModule = module {
        factory { (view: MainContract.View) -> MainPresenter(view, get()) }
    }

    val detailModule = module {
        factory { (view: DetailContract.View) -> DetailPresenter(view) }
    }
}