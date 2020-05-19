package com.android.roomdatabaseappjava;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


import com.android.roomdatabaseappjava.adapter.WordAdapter;
import com.android.roomdatabaseappjava.data.Word;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int REQUESE_CODE = 101;
    WordViewModel mWordViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, NewWordActivity.class),REQUESE_CODE);
            }
        });


        WordAdapter adapter = new WordAdapter(WordAdapter.diffCallback);

        RecyclerView recyclerView = findViewById(R.id.rvWordList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        mWordViewModel = new ViewModelProvider(this).get(WordViewModel.class);

        mWordViewModel.getAllWords().observe(this, new Observer<List<Word>>() {
            @Override
            public void onChanged(List<Word> words) {
                adapter.submitList(words);
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUESE_CODE){
            if (resultCode == Activity.RESULT_OK){
                String word = data.getStringExtra(NewWordActivity.EXTRA_WORD);
                mWordViewModel.insert(new Word(word));

            } else {
                Toast.makeText(this, "Empty", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
