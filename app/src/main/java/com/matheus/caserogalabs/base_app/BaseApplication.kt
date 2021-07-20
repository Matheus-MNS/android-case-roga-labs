package com.matheus.caserogalabs.base_app

import android.app.Application
import com.matheus.caserogalabs.feature.comment_user_post.di.commentUserPostModule
import com.matheus.caserogalabs.feature.user_post.di.userPostModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            modules(
                userPostModule +
                        commentUserPostModule

            ).androidContext(applicationContext)
        }
    }
}