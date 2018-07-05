package com.example.levon.lebona;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class PostAddActivity extends AppCompatActivity {

    Model model;
    final static String KEY_FOR_GET = "hi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_add);
        final EditText editText = findViewById(R.id.pathofimage);
        Button button = findViewById(R.id.addpath);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model = new Model(editText.getText().toString());
            }
        });
        Intent intent = getIntent();
        ArrayList<Model> arrayList = (ArrayList<Model>) intent.getExtras().get(MainActivity.KEY_FOR_ADD);
        arrayList.add(model);
        intent.putExtra(KEY_FOR_GET, arrayList);
        setResult(RESULT_OK, intent);
        finish();
    }
}
