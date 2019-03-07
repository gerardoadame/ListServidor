package com.example.listservidor;


import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;


public class VolleySigleton2 {



    private static VolleySigleton2 instanceSigleton=null;
    private RequestQueue requestQueue;

    private VolleySigleton2(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }



    public static VolleySigleton2 getInstanceSigleton(Context context) {
        if(instanceSigleton == null){
            instanceSigleton = new VolleySigleton2(context);
        }


        return instanceSigleton;
    }


    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
