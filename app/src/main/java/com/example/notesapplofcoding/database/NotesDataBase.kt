package com.example.notesapplofcoding.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.notesapplofcoding.data.Note

@Database(entities = [Note::class], version = 1)
abstract class NotesDataBase:RoomDatabase() {

    abstract val noteDao: NoteDao

    companion object{
      /*  @Volatile
        var INSTANCE: NotesDataBase?=null

        @Synchronized
        fun getDataBaseInstance(context: Context):NotesDataBase {
            if(INSTANCE==null){
                INSTANCE=Room.databaseBuilder(
                    context,
                    NotesDataBase::class.java,
                    "myNotesDB"
                ).fallbackToDestructiveMigration().build()
            }
            return INSTANCE!!
        }*/
    }

}