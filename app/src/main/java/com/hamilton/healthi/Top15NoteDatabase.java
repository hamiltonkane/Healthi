package com.hamilton.healthi;

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
            top15NoteDao.top15Insert(new Top15Note("Coronary Artery Disease", 1, "This condition is caused by a buildup of plaque in your coronary arteries. Early symptoms may include chest pain during exercise, shortness of breath, pain in the jaw, arm, or back, heart palpitations, weakness, dizziness, and irregular heartbeat. Treatments for this condition include eating a healthy diet, getting more exercise, losing weight if needed, medications to control blood pressure, and sometimes surgery to bypass the blocked arteries."));
            top15NoteDao.top15Insert(new Top15Note("Hypertension (High Blood Pressure)", 2, "In most cases, there's no one cause of high blood pressure. It often happens with age. Other risk factors are being overweight, having a family history, heavy drinking, lack of exercise, and poor diet. Most people who have high blood pressure don't have any symptoms, you can have it for years and not know it. In more severe cases, it can cause headaches, shortness of breath, nosebleeds, and extreme anxiety. You may be able to lower blood pressure by going on a diet, limiting daily salt intake, exercising daily, managing stress, and quitting smoking."));
            top15NoteDao.top15Insert(new Top15Note("Common Cold", 3, "Colds spread easily from person to person and are the most common illness in the world. Symptoms of a common cold may include throat pain and sensitivity, sneezing, runny or stuffy nose, low-grade fever, headache, muscle aches, cough, and tiredness. Colds usually get better on their own in a few days. Antihistamines, decongestants, pain relievers, drinking plenty of fluids, and breathing in steam may help ease symptoms."));
            top15NoteDao.top15Insert(new Top15Note("Flu", 4, "The flu is a respiratory tract infection caused by the influenza virus, and spreads easily from person to person. Flu symptoms include fever, sore throat, runny nose, headache, cough, muscle aches, and tiredness. The flu usually gets better on its own in one to two weeks with rest. Antihistamines, decongestants, pain relievers, drinking plenty of fluids, and inhaling steam may help ease symptoms. For people at risk for complications and those with severe symptoms, antiviral medications may help reduce the duration of symptoms and prevent complications if they are taken soon after symptoms appear."));
            top15NoteDao.top15Insert(new Top15Note("Eye Allergies", 5, "Pollen, dust mites, mold, pet dander, and other allergens can trigger a reaction in the clear layer over the eye, called the conjunctiva. Eye allergy symptoms include red, itchy, burning, and watery eyes. Your eyelids may be puffy and your vision blurry. Treatments include avoiding allergens, taking antihistamines and decongestants, and in some cases, allergy shots to reduce the body's response to the allergen."));
            top15NoteDao.top15Insert(new Top15Note("Depression", 6, "Many people feel down for short periods, but depression lasts a long time. Life events such as the death of a loved one can trigger depression. Some symptoms may include a lack of enjoyment in previously enjoyed activities, hopelessness, anxiety, nervousness, insomnia, excess sleeping, frustration, decreased or increased appetite, lack of motivation, and suicidal thoughts. Depression treatments may include antidepressant medication, counseling, and electroconvulsive therapy for severe depression and if some antidepressants don't work."));
            top15NoteDao.top15Insert(new Top15Note("Cancer", 7, "Cancer can cause almost any type of sign or symptom. Some of the most common signs and symptoms of cancer include weight loss, fever, tiredness, a lump or other changes in the skin, pain, cough, indigestion, unusual bleeding, changes in the mouth, swollen lymph nodes, being out of breath, bloating, and anemia. Some treatments of cancer may include surgery, chemotherapy, and radiation therapy."));
            top15NoteDao.top15Insert(new Top15Note("Diabetes, Type 2", 8, "Type 2 diabetes occurs when the body does not make enough insulin or does not use it as it should. Being overweight increases your risk for type 2 diabetes, but not everyone who is overweight will develop the illness. Some symptoms include fatigue, increased appetite, slow-healing or frequent infections, excess thirst, and blurry vision. Some treatments for diabetes include going on a diet, getting more exercise, losing weight if needed, taking oral medications, and taking insulin."));
            top15NoteDao.top15Insert(new Top15Note("Strep Throat", 9, "Strep throat is a throat infection caused by streptococcal bacteria. Symptoms include red throat, white patches on throat, throat pain, trouble swallowing, swollen lymph glands, nausea, fever, chills, muscle aches, stomach aches, rash, and headache. Strep throat should be treated with antibiotics to shorten the illness, prevent potentially serious complications, and also make it less contagious after 48 hours of treatment. Self-cares for this illness include gargling with warm salt water, over-the-counter pain relievers, drinking plenty of fluids, rest, and not smoking."));
            top15NoteDao.top15Insert(new Top15Note("Alzheimer's", 10, "Alzheimer's is a type of dementia that causes connections between neurons in the brain to break down and eventually die. Risk factors include old age, a family history of Alzheimer's, having certain genes, being female, a serious head injury, and having fewer than eight years of education. Some symptoms include trouble with short-term memory, confusion, changes in behavior, not recognizing loved ones, problems making decisions, and trouble swallowing, talking, and walking. Treatments include taking certain medications, vitamin E, and antidepressants."));
            top15NoteDao.top15Insert(new Top15Note("Pneumonia", 11, "This condition is commonly caused by bacteria or viruses. Some risk factors include old age, living in a nursing home, smoking, having a recent cold or flu, having asthma, having a weak immune system, and having recent surgery or injury. Symptoms may include cough, chest pain, headache, sore throat, shortness of breath, wheezing, fever, chills, confusion, and tiredness. Treatments may include antibiotics, antiviral therapy, oxygen, and steroids."));
            top15NoteDao.top15Insert(new Top15Note("Bronchitis", 12, "Cold viruses are the most common cause of bronchitis, but it can also be caused by bacteria. Smoking, air pollution, asthma, and dehydration make this condition worse. Symptoms of this illness include cough, dark or yellow mucus, wheezing, chest pain, and shortness of breath. Treatments may include rest, drinking plenty of fluids, breathing in warm, moist air, over-the-counter pain relievers, and medications to help reduce coughing and open your airways."));
            top15NoteDao.top15Insert(new Top15Note("Tuberculosis", 13, "Tuberculosis spreads when an infected person coughs, sneezes, speaks, or sings, which releases droplets into the air that other people can breath in. If not treated, the illness can be serious and even fatal. Symptoms may include a bad cough, coughing up blood, chest pain, night sweats, fever, chills, fatigue, loss of appetite, and weight loss. Treatments include taking certain medications for 6 months to a year to kill bacteria. It's very important to take your medication exactly as directed."));
            top15NoteDao.top15Insert(new Top15Note("Chronic Obstructive Pulmonary Disease", 14, "Smoking is the most common cause of COPD. It often takes many years to develop. Some symptoms include shortness of breath, tiredness, weakness, a chronic cough, difficulty exercising, wheezing, chest tightness, and turning blue with exertion. Some risk factors are smoking, having been exposed to secondhand smoke, being over age 40, and being exposed to fumes, dust, or air pollution. Treatments may include quitting smoking, medications to open airways, oxygen, pulmonary rehabilitation, and sometimes surgery."));
            top15NoteDao.top15Insert(new Top15Note("Cirrhosis", 15, "Cirrhosis is a long term liver disease. The leading causes are excessive alcoholism and chronic hepatitis C virus infection. Many people have no symptoms in the early stages. As it progressives, symptoms may include tiredness, loss of appetite, nausea and vomiting, abdominal pain and bloating, yellowish skin, itching, enlarged tips of the fingers, and unusual bruising and bleeding. Cirrhosis can't be cured, but it is possible to prevent further damage to the liver. This includes stopping drinking and avoiding medications that may be toxic to the liver."));

            return null;
        }
    }
}
