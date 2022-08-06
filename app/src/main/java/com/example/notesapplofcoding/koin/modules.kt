package com.example.notesapplofcoding.koin

import android.content.Context
import androidx.room.Room
import com.example.notesapplofcoding.NotesApp
import com.example.notesapplofcoding.ViewModel.NotesViewModel
import com.example.notesapplofcoding.database.NotesDataBase
import com.example.notesapplofcoding.repositories.NotesRepo
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule= module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            NotesDataBase::class.java,
            "myNotesDB"
        ).fallbackToDestructiveMigration().build()

    }

    single<NotesRepo> {
        NotesRepo(get())
    }

    viewModel {
       NotesViewModel(get())
    }
}