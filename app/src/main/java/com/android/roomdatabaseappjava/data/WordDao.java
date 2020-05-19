package com.android.roomdatabaseappjava.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;


@Dao
public interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWord();

    @Query("DELETE FROM word_table")
    void deleteAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Word word);
}
