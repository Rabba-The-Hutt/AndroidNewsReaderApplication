package org.robertlyon.newsreader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;


    public static ArrayList<String> newsArticles = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        newsArticles.add("hello");
        newsArticles.add("my");
        newsArticles.add("name");
        newsArticles.add("is");
        newsArticles.add("Robert");

        mAdapter = new Adapter(this, newsArticles);
        mRecyclerView.setAdapter(mAdapter);


    }
}
