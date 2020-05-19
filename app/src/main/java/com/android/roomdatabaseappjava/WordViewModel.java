package com.android.roomdatabaseappjava;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.android.roomdatabaseappjava.data.Word;

import java.util.List;

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;

    private LiveData<List<Word>> mAllWords;

    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository  = new WordRepository(application);
        mAllWords = wordRepository.getAllWords();
    }

    LiveData<List<Word>> getAllWords(){
        return mAllWords;
    }

    void insert(Word word){
        wordRepository.insert(word);
    }
}
