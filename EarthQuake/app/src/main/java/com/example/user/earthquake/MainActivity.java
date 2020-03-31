package com.example.user.earthquake;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    public static RecyclerView recyclerView;
    public static RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    //ArrayList<earthquakeDetailList> arrayList=new ArrayList<>();
    String geo_url="https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        arrayList.add(new earthquakeDetailList("Ramgarh",6.53555,"26-10.1988","452255"));
//        arrayList.add(new earthquakeDetailList("Ranchi",7.32,"23-10.1988","452365"));
//        arrayList.add(new earthquakeDetailList("Boakaro",8.0,"26-10.1999","458366"));
//        arrayList.add(new earthquakeDetailList("chaibasa",.156,"26-10.1996","68445"));
//        arrayList.add(new earthquakeDetailList("padma",6.323,"26-10.1958","985555"));

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
//        mAdapter = new MyAdapter(arrayList);
//         recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(layoutManager);
        Log.d("akash","before Request");


    }

    @Override
    protected void onStart() {
        super.onStart();

        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, geo_url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONArray jsonArray=response.getJSONArray("features");
                    Log.d("akash","a");
                    int count=0;
                    ArrayList<earthquakeDetailList> sprt=new ArrayList<>();
                    Log.d("akash",jsonArray.length()+"kk");
                    while (count<jsonArray.length())
                    {
                        Log.d("akash","b ");

                        JSONObject jsonObject=jsonArray.getJSONObject(count).getJSONObject("properties");
                        Log.d("akash", "1");
                        Log.d("akash",jsonObject.getString("place"));
                        Log.d("akash", "2");
                        earthquakeDetailList earthquakeDetailList=new earthquakeDetailList(jsonObject.getString("place"),jsonObject.getDouble("mag")
                                ,jsonObject.getString("time"),jsonObject.getString("title"));

                        sprt.add(earthquakeDetailList);
                        count++;

                    }
                    mAdapter = new MyAdapter(sprt);

                    recyclerView.setAdapter(mAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.d("akash","Not able to go inside while loop");
                }




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Log.d("akash","Something went wrong ");

            }
        });

        mySingelton.getInstance(MainActivity.this).addToRequestQueue(jsonObjectRequest);
        Log.d("akash","At Last");
    }
}
