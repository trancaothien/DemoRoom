package com.tct.androidnotes.database;

import android.provider.ContactsContract;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.tct.androidnotes.model.Note;

import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM Note")
    List<Note> getAllNote();

    @Insert
    void insertNote(Note note);

    @Query("DELETE FROM Note")
    void delete();
}
