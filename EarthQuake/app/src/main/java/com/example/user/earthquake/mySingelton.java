package com.example.user.earthquake;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

public class mySingelton {
    private static mySingelton instance;
   public RequestQueue requestQueue;

    private static Context ctx;

    private mySingelton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();

    }

    public static synchronized mySingelton getInstance(Context context) {
        if (instance == null) {
            instance = new mySingelton(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {

            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }

}
