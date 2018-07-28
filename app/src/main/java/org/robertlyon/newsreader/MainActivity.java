package org.robertlyon.newsreader;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.jar.JarOutputStream;

public class MainActivity extends AppCompatActivity {


    //Load corresponding article to webview when clicked
    //Find a way to access url from JSON object
    //Save data to database
    //Look into JSON code, try and find a way to make it faster

    

    public RecyclerView mRecyclerView;
    public RecyclerView.Adapter mAdapter;

    public static ArrayList<String> newsArticles = new ArrayList<>();

    public void enterCard(View v)
    {
        Intent anIntent = new Intent(this, webView.class);
        startActivity(anIntent);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = findViewById(R.id.recyView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        //Working out the JSON issue
        try {
            new JsonTask().execute("https://hacker-news.firebaseio.com/v0/topstories.json?print=pretty").get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        Log.i("new", newsArticles.toString());


        mAdapter = new Adapter(this, newsArticles);
        mRecyclerView.setAdapter(mAdapter);
    }
}
