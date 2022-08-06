package com.example.notesapplofcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notesapplofcoding.ViewModel.NotesViewModel
import com.example.notesapplofcoding.ViewModel.providerFactory.NotesViewModelProviderFactory
import com.example.notesapplofcoding.database.NotesDataBase
import com.example.notesapplofcoding.repositories.NotesRepo

class MainActivity : AppCompatActivity() {

    val viewModel: NotesViewModel by lazy {
        val database = NotesDataBase.getDataBaseInstance(this)
        val notesRepo=NotesRepo(database)
        val notesProviderFactory=NotesViewModelProviderFactory(notesRepo)
        ViewModelProvider(this, notesProviderFactory).get(NotesViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}