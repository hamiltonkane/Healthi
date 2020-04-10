package com.hamilton.healthi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "all_note_table")
public class AllNote {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private String description;

    public AllNote(String title, String description) {
        this.title = title;
        this.description = description;
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

    public String getDescription() { return description; }
}
