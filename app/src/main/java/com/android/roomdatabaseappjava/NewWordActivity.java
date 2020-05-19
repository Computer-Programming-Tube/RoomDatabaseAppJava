package com.android.roomdatabaseappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewWordActivity extends AppCompatActivity {

    public static final String EXTRA_WORD = "extra_word";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        EditText editText = findViewById(R.id.editText);
        Button save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();

                if(TextUtils.isEmpty(editText.getText().toString())){
                    setResult(Activity.RESULT_CANCELED, intent);
                } else {
                    intent.putExtra(EXTRA_WORD, editText.getText().toString());
                    setResult(Activity.RESULT_OK, intent);
                }
                finish();

            }
        });
    }
}
