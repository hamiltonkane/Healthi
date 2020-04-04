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
            allNoteDao.allInsert(new AllNote("ADHD"));
            allNoteDao.allInsert(new AllNote("Allergies"));
            allNoteDao.allInsert(new AllNote("Alopecia"));
            allNoteDao.allInsert(new AllNote("Alzheimer's"));
            allNoteDao.allInsert(new AllNote("Arthritis"));
            allNoteDao.allInsert(new AllNote("Asthma"));
            allNoteDao.allInsert(new AllNote("Back Pain"));
            allNoteDao.allInsert(new AllNote("Bipolar Disorder"));
            allNoteDao.allInsert(new AllNote("Borderline Personality Disorder"));
            allNoteDao.allInsert(new AllNote("Brain Tumor"));
            allNoteDao.allInsert(new AllNote("Bronchitis"));
            allNoteDao.allInsert(new AllNote("Cancer"));
            allNoteDao.allInsert(new AllNote("Carpal Tunnel Syndrome"));
            allNoteDao.allInsert(new AllNote("Celiac Disease"));
            allNoteDao.allInsert(new AllNote("Chickenpox"));
            allNoteDao.allInsert(new AllNote("Chronic Obstructive Pulmonary Disease"));
            allNoteDao.allInsert(new AllNote("Cirrhosis"));
            allNoteDao.allInsert(new AllNote("Cold"));
            allNoteDao.allInsert(new AllNote("Coronary Heart-Disease"));
            allNoteDao.allInsert(new AllNote("Coronavirus"));
            allNoteDao.allInsert(new AllNote("Dandruff"));
            allNoteDao.allInsert(new AllNote("Dementia"));
            allNoteDao.allInsert(new AllNote("Depression"));
            allNoteDao.allInsert(new AllNote("Diabetes"));
            allNoteDao.allInsert(new AllNote("Ear Infection"));
            allNoteDao.allInsert(new AllNote("Epilepsy"));
            allNoteDao.allInsert(new AllNote("Flu"));
            allNoteDao.allInsert(new AllNote("Gingivitis"));
            allNoteDao.allInsert(new AllNote("Hypertension (High Blood Pressure)"));
            allNoteDao.allInsert(new AllNote("Insomnia"));
            allNoteDao.allInsert(new AllNote("Kidney Stones"));
            allNoteDao.allInsert(new AllNote("Malaria"));
            allNoteDao.allInsert(new AllNote("Migraine"));
            allNoteDao.allInsert(new AllNote("Osteoporosis"));
            allNoteDao.allInsert(new AllNote("Pneumonia"));
            allNoteDao.allInsert(new AllNote("Psoriasis"));
            allNoteDao.allInsert(new AllNote("Schizophrenia"));
            allNoteDao.allInsert(new AllNote("Scoliosis"));
            allNoteDao.allInsert(new AllNote("Strep Throat"));
            allNoteDao.allInsert(new AllNote("Tuberculosis"));

            return null;
        }
    }
}
