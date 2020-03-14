package com.hamilton.cureall;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = Top15Note.class, version = 1, exportSchema = false)
public abstract class Top15NoteDatabase extends RoomDatabase {

    private static Top15NoteDatabase top15Instance;

    public abstract Top15NoteDao top15NoteDao();

    public static synchronized Top15NoteDatabase getInstance(Context context) {
        if (top15Instance == null) {
            top15Instance = Room.databaseBuilder(context.getApplicationContext(),
                    Top15NoteDatabase.class, "Top_15_Note_Database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return top15Instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(top15Instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private Top15NoteDao top15NoteDao;

        private PopulateDbAsyncTask(Top15NoteDatabase db) {
            top15NoteDao = db.top15NoteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            top15NoteDao.insert(new Top15Note("Title 1", 1));
            top15NoteDao.insert(new Top15Note("Title 2", 2));
            top15NoteDao.insert(new Top15Note("Title 3", 3));
            return null;
        }
    }
}
