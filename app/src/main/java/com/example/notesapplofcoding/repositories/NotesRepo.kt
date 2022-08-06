package com.example.notesapplofcoding.repositories

import com.example.notesapplofcoding.data.Note
import com.example.notesapplofcoding.database.NotesDataBase

class NotesRepo (
    val notesDb: NotesDataBase
){
    val notesDao=notesDb.noteDao

    suspend fun upsertNote(note:Note)=notesDao.upsertNote(note)
    suspend fun searchInNoteTitle(searchQuery: String)=notesDao.searchNotesTitle(searchQuery)
    suspend fun deleteNote(note:Note)=notesDao.deleteNote(note)
    fun getNotes()=notesDao.getNotes()
    suspend fun deleteNotes()=notesDao.deleteNotes()
}
