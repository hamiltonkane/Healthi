package com.hamilton.healthi;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class AllNoteRepository {
    private AllNoteDao allNoteDao;
    private LiveData<List<AllNote>> allAllNotes;

    public AllNoteRepository(Application application) {
        AllNoteDatabase allDatabase = AllNoteDatabase.getInstance(application);
        allNoteDao = allDatabase.allNoteDao();
        allAllNotes = allNoteDao.allGetAllNotes();
    }

    public void insert(AllNote allNote) {
        new InsertNoteAsyncTask(allNoteDao).execute(allNote);
    }

    public void update(AllNote allNote) {
        new UpdateNoteAsyncTask(allNoteDao).execute(allNote);
    }

    public void delete(AllNote allNote) {
        new DeleteNoteAsyncTask(allNoteDao).execute(allNote);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(allNoteDao).execute();
    }

    public LiveData<List<AllNote>> getAllAllNotes() {
        return allAllNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<AllNote, Void, Void> {
        private AllNoteDao allNoteDao;

        private InsertNoteAsyncTask(AllNoteDao allNoteDao) {
            this.allNoteDao = allNoteDao;
        }

        @Override
        protected Void doInBackground(AllNote... allNotes) {
            allNoteDao.allInsert(allNotes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<AllNote, Void, Void> {
        private AllNoteDao allNoteDao;

        private UpdateNoteAsyncTask(AllNoteDao allNoteDao) {
            this.allNoteDao = allNoteDao;
        }

        @Override
        protected Void doInBackground(AllNote... allNotes) {
            allNoteDao.allUpdate(allNotes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<AllNote, Void, Void> {
        private AllNoteDao allNoteDao;

        private DeleteNoteAsyncTask(AllNoteDao allNoteDao) {
            this.allNoteDao = allNoteDao;
        }

        @Override
        protected Void doInBackground(AllNote... allNotes) {
            allNoteDao.allDelete(allNotes[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private AllNoteDao allNoteDao;

        private DeleteAllNotesAsyncTask(AllNoteDao allNoteDao) {
            this.allNoteDao = allNoteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            allNoteDao.allDeleteAllNotes();
            return null;
        }
    }
}
