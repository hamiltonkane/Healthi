package com.hamilton.healthi;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AllNoteDao {

    @Insert
    void allInsert(AllNote note);

    @Update
    void allUpdate(AllNote note);

    @Delete
    void allDelete(AllNote note);

    @Query("DELETE FROM all_note_table")
    void allDeleteAllNotes();

    @Query("SELECT * FROM all_note_table")
    LiveData<List<AllNote>> allGetAllNotes();
}
