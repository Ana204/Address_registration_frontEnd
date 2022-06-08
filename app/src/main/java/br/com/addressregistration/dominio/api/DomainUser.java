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

import org.json.JSONException;
import org.json.JSONObject;

import br.com.addressregistration.Utils.Utils;
import br.com.addressregistration.model.Users_model;

public class DomainUser {

    RequestQueue queue;
    Context context;

    public DomainUser(Context context) {
        this.context = context;
    }

    public void GetUsers(){
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

    public void PostUsers(Users_model usersModel) {
        queue = Volley.newRequestQueue(context);

        JSONObject object = new JSONObject();

        try {
            object.put("Id", "2");
            object.put("Nome" , usersModel.getNome());
            object.put("Email", usersModel.getEmail());
            object.put("Telefone", usersModel.getTelefone());
            object.put("Cep", usersModel.getCep());

        }catch (JSONException e){
            Log.i("POST", "postData: " + e.getMessage());
        }

        JsonObjectRequest postRequestUsers = new JsonObjectRequest(Request.Method.POST, Utils.URL_POST, object,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("POST", "JsonObject: " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("POST", "onErrorResponse: " + error);
            }
        });

        postRequestUsers.setRetryPolicy(new DefaultRetryPolicy(
                6000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_TIMEOUT_MS
        ));

        queue.add(postRequestUsers);
    }
}
