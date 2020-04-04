package com.hamilton.healthi;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Top15NoteRepository {
    private Top15NoteDao top15NoteDao;
    private LiveData<List<Top15Note>> top15AllNotes;

    public Top15NoteRepository(Application application) {
        Top15NoteDatabase top15Database = Top15NoteDatabase.getInstance(application);
        top15NoteDao = top15Database.top15NoteDao();
        top15AllNotes = top15NoteDao.top15GetAllNotes();
    }

    public void insert(Top15Note top15Note) {
        new InsertNoteAsyncTask(top15NoteDao).execute(top15Note);
    }

    public void update(Top15Note top15Note) {
        new UpdateNoteAsyncTask(top15NoteDao).execute(top15Note);
    }

    public void delete(Top15Note top15Note) {
        new DeleteNoteAsyncTask(top15NoteDao).execute(top15Note);
    }

    public void deleteAllNotes() {
        new DeleteAllNotesAsyncTask(top15NoteDao).execute();
    }

    public LiveData<List<Top15Note>> getTop15AllNotes() {
        return top15AllNotes;
    }

    private static class InsertNoteAsyncTask extends AsyncTask<Top15Note, Void, Void> {
        private Top15NoteDao top15NoteDao;

        private InsertNoteAsyncTask(Top15NoteDao top15NoteDao) {
            this.top15NoteDao = top15NoteDao;
        }

        @Override
        protected Void doInBackground(Top15Note... top15Notes) {
            top15NoteDao.top15Insert(top15Notes[0]);
            return null;
        }
    }

    private static class UpdateNoteAsyncTask extends AsyncTask<Top15Note, Void, Void> {
        private Top15NoteDao top15NoteDao;

        private UpdateNoteAsyncTask(Top15NoteDao top15NoteDao) {
            this.top15NoteDao = top15NoteDao;
        }

        @Override
        protected Void doInBackground(Top15Note... top15Notes) {
            top15NoteDao.top15Update(top15Notes[0]);
            return null;
        }
    }

    private static class DeleteNoteAsyncTask extends AsyncTask<Top15Note, Void, Void> {
        private Top15NoteDao top15NoteDao;

        private DeleteNoteAsyncTask(Top15NoteDao top15NoteDao) {
            this.top15NoteDao = top15NoteDao;
        }

        @Override
        protected Void doInBackground(Top15Note... top15Notes) {
            top15NoteDao.top15Delete(top15Notes[0]);
            return null;
        }
    }

    private static class DeleteAllNotesAsyncTask extends AsyncTask<Void, Void, Void> {
        private Top15NoteDao top15NoteDao;

        private DeleteAllNotesAsyncTask(Top15NoteDao top15NoteDao) {
            this.top15NoteDao = top15NoteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            top15NoteDao.top15DeleteAllNotes();
            return null;
        }
    }
}
