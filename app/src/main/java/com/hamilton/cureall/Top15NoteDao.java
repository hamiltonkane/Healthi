package com.hamilton.cureall;

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
    void insert(Top15Note note);

    @Update
    void update(Top15Note note);

    @Delete
    void delete(Top15Note note);

    @Query("DELETE FROM note_table")
    void deleteAllNotes();

    @Query("SELECT * FROM note_table ORDER BY priority DESC")
    LiveData<List<Top15Note>> top15GetAllNotes();
}
