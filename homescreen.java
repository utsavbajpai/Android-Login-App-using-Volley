package com.mycompany.samplelogin;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

/**
 * Created by Utsav on 8/3/2015.
 */


public class homescreen extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homescreen);
        final TextView tv = (TextView)findViewById(R.id.json_text);
        String tag_json_obj = "json_obj_req";
        String url = "http://api.androidhive.info/volley/person_object.json";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET,url,null,new Response.Listener<JSONObject>(){
            @Override
        public void onResponse(JSONObject response)
            {
                tv.setText(response.toString());
            }
        },new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d("E", "Error: " + error.getMessage());
            }

    });

        AppController.getInstance().addToRequestQueue(jsonObjectRequest,tag_json_obj);
}

    }


