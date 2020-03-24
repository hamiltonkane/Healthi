package com.hamilton.healthi;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Top15Note {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;

    private int priority;

    public Top15Note(String title, int priority) {
        this.title = title;
        this.priority = priority;
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
}
