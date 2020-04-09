package com.hamilton.healthi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "top15_note_table")
public class Top15Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private int priority;

    private String description;

    public Top15Note(String title, int priority, String description) {
        this.title = title;
        this.priority = priority;
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

    public int getPriority() {
        return priority;
    }

    public String getDescription() { return description; }
}
