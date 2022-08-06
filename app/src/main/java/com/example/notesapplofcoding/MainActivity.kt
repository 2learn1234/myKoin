package com.example.notesapplofcoding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.notesapplofcoding.ViewModel.NotesViewModel
//import com.example.notesapplofcoding.ViewModel.providerFactory.NotesViewModelProviderFactory
import com.example.notesapplofcoding.database.NotesDataBase
import com.example.notesapplofcoding.databinding.ActivityMainBinding
import com.example.notesapplofcoding.repositories.NotesRepo
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding


//val  db by inject<NotesDataBase>()

/* val viewModel2: NotesViewModel by lazy {
        val database = NotesDataBase.getDataBaseInstance(this)
        val notesRepo=NotesRepo(database)
        val notesProviderFactory=NotesViewModelProviderFactory(notesRepo)
        ViewModelProvider(this, notesProviderFactory).get(NotesViewModel::class.java)
    }*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}