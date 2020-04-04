package com.hamilton.healthi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "all_note_table")
public class AllNote {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    public AllNote(String title) {
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }
}
