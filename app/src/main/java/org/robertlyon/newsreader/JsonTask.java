package org.robertlyon.newsreader;

import android.os.AsyncTask;

import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JsonTask extends AsyncTask<String, String, String> {


    @Override
    protected String doInBackground(String... strings) {

        HttpURLConnection connection = null;
        BufferedReader bufferedReader = null;

        try
        {
            URL url = new URL(strings[0]);
            connection = (HttpURLConnection) url.openConnection();
            connection.connect();

            InputStream stream = connection.getInputStream();
            bufferedReader = new BufferedReader(new InputStreamReader(stream));

            StringBuilder buffer = new StringBuilder();
            String line = "";

            while((line = bufferedReader.readLine()) != null)
            {
                buffer.append(line);
            }


            String b = buffer.toString();

            List<String> listOfArticles = Arrays.asList(b.split("\\s*,\\s*"));
            List<String> listOfAtricles100 = new ArrayList<>(listOfArticles.subList(1, 10));


            for(String article : listOfAtricles100)
            {
                URL pageUrl = new URL("https://hacker-news.firebaseio.com/v0/item/" + article + ".json?print=pretty");
                HttpURLConnection pageUrlConnection = (HttpURLConnection) pageUrl.openConnection();
                InputStream in = pageUrlConnection.getInputStream();
                BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(in));

                StringBuilder result = new StringBuilder();
                String aLine = "";

                while ((aLine = bufferedReader1.readLine()) != null)
                {
                    result.append(aLine);
                }

                String aResult = result.toString();


                JSONObject jsonObject = new JSONObject(aResult);
                String title = jsonObject.getString("title");
                MainActivity.newsArticles.add(title);

            }

            return buffer.toString();




        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally {
            if(connection != null)
            {
                connection.disconnect();
            }
            try
            {
                if(bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        return null;
    }
}
