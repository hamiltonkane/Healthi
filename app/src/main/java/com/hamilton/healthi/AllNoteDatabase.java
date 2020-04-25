package com.hamilton.healthi;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = AllNote.class, version = 1, exportSchema = false)
public abstract class AllNoteDatabase extends RoomDatabase {

    private static AllNoteDatabase allInstance;

    public abstract AllNoteDao allNoteDao();

    public static synchronized AllNoteDatabase getInstance(Context context) {
        if (allInstance == null) {
            allInstance = Room.databaseBuilder(context.getApplicationContext(),
                    AllNoteDatabase.class, "All_Note_Database")
                    .fallbackToDestructiveMigration()
                    .addCallback(allRoomCallback)
                    .build();
        }
        return allInstance;
    }

    private static RoomDatabase.Callback allRoomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(allInstance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private AllNoteDao allNoteDao;

        private PopulateDbAsyncTask(AllNoteDatabase db) {
            allNoteDao = db.allNoteDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            allNoteDao.allInsert(new AllNote("ADHD", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Allergies", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Alopecia", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Alzheimer's", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Arthritis", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Asthma", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Back Pain", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Bipolar Disorder", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Borderline Personality Disorder", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Brain Tumor", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Bronchitis", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Cancer", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Carpal Tunnel Syndrome", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Celiac Disease", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Chickenpox", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Chronic Obstructive Pulmonary Disease", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Cirrhosis", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Cold", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Coronary Artery Disease", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Coronavirus", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Dandruff", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Dementia", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Depression", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Diabetes", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Ear Infection", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Epilepsy", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Flu", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Gingivitis", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Hypertension (High Blood Pressure)", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Insomnia", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Kidney Stones", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Malaria", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Migraine", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Osteoporosis", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Pneumonia", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Psoriasis", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Schizophrenia", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Scoliosis", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Strep Throat", "Description of Illness"));
            allNoteDao.allInsert(new AllNote("Tuberculosis", "Description of Illness"));

            return null;
        }
    }
}
