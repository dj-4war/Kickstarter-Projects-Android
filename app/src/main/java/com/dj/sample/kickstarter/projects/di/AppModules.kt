package com.dj.sample.kickstarter.projects.di

import com.dj.sample.kickstarter.projects.repositories.IProjectsRepo
import com.dj.sample.kickstarter.projects.repositories.ProjectsRepoImpl
import com.dj.sample.kickstarter.projects.utils.ConnectionUtils
import com.dj.sample.kickstarter.projects.viewmodels.ProjectsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModules = module{

    // single instance of HelloRepository
    single<IProjectsRepo> {
        ProjectsRepoImpl()
    }

    viewModel{   // Returns or binds  ViewModel directly
        ProjectsViewModel(get())
    }
    single {
        ConnectionUtils(get())
    }
}