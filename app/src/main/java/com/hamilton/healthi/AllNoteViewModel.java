package com.hamilton.healthi;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class AllNoteViewModel extends AndroidViewModel {
    private AllNoteRepository repository;
    private LiveData<List<AllNote>> allAllNotes;

    public AllNoteViewModel(@NonNull Application application) {
        super(application);
        repository = new AllNoteRepository(application);
        allAllNotes = repository.getAllAllNotes();
    }

    public void insert(AllNote allNote) {
        repository.insert(allNote);
    }

    public void update(AllNote allNote) {
        repository.update(allNote);
    }

    public void delete(AllNote allNote) {
        repository.delete(allNote);
    }

    public void deleteAllNotes(AllNote allNote) {
        repository.deleteAllNotes();
    }

    public LiveData<List<AllNote>> getAllAllNotes() {
        return allAllNotes;
    }
}
