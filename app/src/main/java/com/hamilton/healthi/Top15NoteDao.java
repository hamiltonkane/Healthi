package com.hamilton.healthi;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface Top15NoteDao {

    @Insert
    void top15Insert(Top15Note note);

    @Update
    void top15Update(Top15Note note);

    @Delete
    void top15Delete(Top15Note note);

    @Query("DELETE FROM top15_note_table")
    void top15DeleteAllNotes();

    @Query("SELECT * FROM top15_note_table")
    LiveData<List<Top15Note>> top15GetAllNotes();
}
