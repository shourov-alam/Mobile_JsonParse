package com.shourov.mobile_jsonparse;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private ArrayList<Pojo> arrayList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rcView);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList=new ArrayList<>();
        //new Json_Parse().execute();
        Json_Parse json_parse=new Json_Parse();
        json_parse.execute();

    }

    public class Json_Parse extends AsyncTask<String,String,String> {

        HttpURLConnection httpURLConnection = null;
        InputStream inputStream;
        BufferedReader bufferedReader;
        StringBuffer stringBuffer;
        String allData;
        String company,name,ram,rom;
        String image_url;


        @Override
        protected String doInBackground(String... strings) {


            try {
                URL url=new URL("https://www.androidtutorialpoint.com/api/MobileJSONArray.json");
                httpURLConnection= (HttpURLConnection) url.openConnection();
                httpURLConnection.connect();
                inputStream=httpURLConnection.getInputStream();
                bufferedReader=new BufferedReader(new InputStreamReader(inputStream));
                stringBuffer=new StringBuffer();
                String line = "";

                while ((line=bufferedReader.readLine()) != null){
                    stringBuffer.append(line);


                }



                allData=stringBuffer.toString();

                JSONArray jsonArray =new JSONArray(allData);

                for(int i=0;i<jsonArray.length();i++){

                    JSONObject jsonObject = jsonArray.getJSONObject(i);

                    company=jsonObject.getString("companyName");
                    name=jsonObject.getString("name");
                    ram=jsonObject.getString("ram");
                    rom=jsonObject.getString("rom");
                    image_url=jsonObject.getString("url");

                    arrayList.add(new Pojo(company,name,ram,rom,image_url));


                }










            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);

            DataAdapter dataAdapter = new DataAdapter(arrayList,getApplicationContext());
            recyclerView.setAdapter(dataAdapter);


           /* LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            recyclerView.setLayoutManager(linearLayoutManager); */


        }
    }

}