package br.com.addressregistration.dominio.api;

import android.content.Context;
import android.util.Log;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import br.com.addressregistration.Utils.Utils;
import br.com.addressregistration.model.FormUsers_model;

public class GetRequestUser {

    RequestQueue queue;
    Context context;

    public GetRequestUser(Context context) {
        this.context = context;
    }

    public void requestUsers(){
        queue = Volley.newRequestQueue(context);

        JsonObjectRequest jsonRequestUsers = new JsonObjectRequest(Request.Method.GET, Utils.URL_USERS, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("JSON", "onResponse: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("JSON", "ERROR: " + error);
            }
        });


        jsonRequestUsers.setRetryPolicy(new DefaultRetryPolicy(
                6000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS
        ));

        queue.add(jsonRequestUsers);
    }
}
