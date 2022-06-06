package br.com.addressregistration.viewModel;


import android.content.Context;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import br.com.addressregistration.dominio.api.User;
import br.com.addressregistration.model.Users_model;

public class Users {

    private Context context;
    private User user;
    private Users_model usersModel;


    public Users(Context context){
        this.context = context;
    }

    //Chama api
    public void GetRest(){
        user = new User(this.context);
        user.GetUsers();
        Log.i("JSON", "A View conseguiu chamar A ApiRest: ");
    }

    public void PostRest(String Name, String Email){

        usersModel = new Users_model(Name, Email);

        user = new User(this.context);
        user.PostUsers(usersModel);
        Log.i("JSON", "A View conseguiu chamar o metodo PostRest: ");
    }


}
