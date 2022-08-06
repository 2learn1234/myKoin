package com.example.notesapplofcoding.ViewModel.providerFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.notesapplofcoding.ViewModel.NotesViewModel
import com.example.notesapplofcoding.repositories.NotesRepo

class NotesViewModelProviderFactory(
    private val notesRepo:NotesRepo
):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
       return NotesViewModel(notesRepo) as T
    }
}