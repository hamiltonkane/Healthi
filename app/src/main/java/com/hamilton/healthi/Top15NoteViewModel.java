package com.hamilton.healthi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class Top15NoteViewModel extends AndroidViewModel {
    private Top15NoteRepository repository;
    private LiveData<List<Top15Note>> top15AllNotes;

    public Top15NoteViewModel(@NonNull Application application) {
        super(application);
        repository = new Top15NoteRepository(application);
        top15AllNotes = repository.getTop15AllNotes();
    }

    public void insert(Top15Note top15Note) {
        repository.insert(top15Note);
    }

    public void update(Top15Note top15Note) {
        repository.update(top15Note);
    }

    public void delete(Top15Note top15Note) {
        repository.delete(top15Note);
    }

    public void deleteAllNotes(Top15Note top15Note) {
        repository.deleteAllNotes();
    }

    public LiveData<List<Top15Note>> getTop15AllNotes() {
        return top15AllNotes;
    }
}
