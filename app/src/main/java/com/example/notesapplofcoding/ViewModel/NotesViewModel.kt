package com.example.notesapplofcoding.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesapplofcoding.data.Note
import com.example.notesapplofcoding.repositories.NotesRepo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

public class NotesViewModel(
    val notesRepo: NotesRepo
):ViewModel() {


    val notes=notesRepo.getNotes()

    private  val _searchableNotes=MutableStateFlow<List<Note>>(emptyList())

    val searchNotes:StateFlow<List<Note>>?=_searchableNotes


    fun upsertNote(note: Note)=viewModelScope.launch {
        notesRepo.upsertNote(note)
    }

    fun deleteNote(note: Note)=viewModelScope.launch {
        notesRepo.deleteNote(note)
    }

    fun searchedNotes(searchQuery: String)=viewModelScope.launch {
        notesRepo.searchInNoteTitle(searchQuery).collect { notesList ->
          _searchableNotes.emit(notesList)
        }
    }

}