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
                    .addCallback(top15RoomCallback)
                    .build();
        }
        return top15Instance;
    }

    private static RoomDatabase.Callback top15RoomCallback = new RoomDatabase.Callback() {
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
            top15NoteDao.insert(new Top15Note("Coronary Heart-Disease", 1));
            top15NoteDao.insert(new Top15Note("Hypertension (High Blood Pressure)", 2));
            top15NoteDao.insert(new Top15Note("Cold", 3));
            top15NoteDao.insert(new Top15Note("Flu", 4));
            top15NoteDao.insert(new Top15Note("Allergies", 5));
            top15NoteDao.insert(new Top15Note("Depression", 6));
            top15NoteDao.insert(new Top15Note("Cancer", 7));
            top15NoteDao.insert(new Top15Note("Diabetes", 8));
            top15NoteDao.insert(new Top15Note("Strep Throat", 9));
            top15NoteDao.insert(new Top15Note("Alzheimer's", 10));
            top15NoteDao.insert(new Top15Note("Pneumonia", 11));
            top15NoteDao.insert(new Top15Note("Bronchitis", 12));
            top15NoteDao.insert(new Top15Note("Tuberculosis", 13));
            top15NoteDao.insert(new Top15Note("Chronic Obstructive Pulmonary Disease", 14));
            top15NoteDao.insert(new Top15Note("Cirrhosis", 15));

            return null;
        }
    }
}
