package com.jjmin.hellobottest.di

import com.jjmin.hellobottest.model.remote.IssueRepository
import com.jjmin.hellobottest.model.remote.IssueRepositoryImpl
import org.koin.dsl.module


object RepositoryModules {

    var issueModules = module{
        factory {
            IssueRepositoryImpl(get()) as IssueRepository
        }
    }
}