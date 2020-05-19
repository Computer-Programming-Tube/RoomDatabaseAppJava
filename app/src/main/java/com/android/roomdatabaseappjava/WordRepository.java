package com.android.roomdatabaseappjava;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.android.roomdatabaseappjava.data.Word;
import com.android.roomdatabaseappjava.data.WordDao;
import com.android.roomdatabaseappjava.data.WordDatabase;

import java.util.List;

public class WordRepository {

    private WordDao mWordDao;

    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordDatabase wordDatabase = WordDatabase.getDatabase(application);
        mWordDao = wordDatabase.wordDao();
        mAllWords = mWordDao.getAllWord();
    }

    public LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    void insert(Word word) {
        WordDatabase.databaseWriteExecutor.execute(() -> {
            mWordDao.insert(word);
        });
    }
}
