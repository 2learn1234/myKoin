package com.example.notesapplofcoding

import android.app.Application
import com.example.notesapplofcoding.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class NotesApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@NotesApp)
            modules(appModule)
        }
    }
}