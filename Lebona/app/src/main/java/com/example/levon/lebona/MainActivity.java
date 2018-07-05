package com.example.levon.lebona;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    FloatingActionButton floatingActionButton;
    final static int ADD_REQUEST = 2;
    final static String KEY_FOR_ADD = "hello";
    private ArrayList<Model> arrayList;
    private AdapterForPosts adapterForPosts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        floatingActionButton = findViewById(R.id.fab);
        arrayList = new ArrayList<>();
        arrayList.add(new Model("https://vignette.wikia.nocookie.net/darksouls/images/2/24/Solar_from_astora.png/revision/latest?cb=20160606060110&path-prefix=ru"));
        arrayList.add(new Model("https://vignette.wikia.nocookie.net/darksouls/images/2/24/Solar_from_astora.png/revision/latest?cb=20160606060110&path-prefix=ru"));
        arrayList.add(new Model("https://vignette.wikia.nocookie.net/darksouls/images/2/24/Solar_from_astora.png/revision/latest?cb=20160606060110&path-prefix=ru"));
        adapterForPosts = new AdapterForPosts(arrayList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerid);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterForPosts);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PostAddActivity.class);
                intent.putExtra(KEY_FOR_ADD, arrayList);
                startActivityForResult(intent, ADD_REQUEST);
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_REQUEST) {
            if (resultCode == RESULT_OK && data != null) {
                arrayList = (ArrayList<Model>) data.getExtras().get(PostAddActivity.KEY_FOR_GET);
            }
        }
    }
}
