package com.dj.sample.kickstarter.projects.app

import android.app.Application
import com.dj.sample.kickstarter.projects.di.appModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

/**
 * Starting point of the application
 */

class KickstarterApp : Application(){

    override fun onCreate() {
        startKoin {
            androidContext(this@KickstarterApp)
            modules(appModules)
        }
        super.onCreate()
    }
}