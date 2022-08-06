package com.example.notesapplofcoding.database

import androidx.room.*
import com.example.notesapplofcoding.data.Note
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertNote(note: Note)

    @Delete
    suspend fun deleteNote(note:Note)

    @Query("SELECT * FROM Note ORDER BY nodeId DESC")
    fun getNotes():Flow<List<Note>>

    @Query("SELECT * FROM Note WHERE noteTitle LIKE '%' ||:searchQuery|| '%'")
    fun searchNotesTitle(searchQuery:String):Flow<List<Note>>

    @Query("DELETE FROM Note")
    suspend fun deleteNotes()
}