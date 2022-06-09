package br.com.addressregistration.viewModel;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import br.com.addressregistration.dominio.api.DomainUser;
import br.com.addressregistration.model.Users_model;

public class Users {

    private Context context;
    private DomainUser user;
    Users_model usersModel;

    public Users(Context context){
        this.context = context;
    }

    //Chama api
    public void RequestUsers(){
        user = new DomainUser(this.context);
        user.GetUsers();
        Log.i("JSON", "A ViewModel conseguiu chamar o metodo RequestUsers: ");
    }

    //chama endPoint post
    public void PostUsers(String name, String email, String telephone, String cep){
        user = new DomainUser(this.context);

        try {
            usersModel = new Users_model(name, email, telephone, cep);
            user.PostUsers(usersModel);

        }catch (IllegalArgumentException e){

            throw new IllegalArgumentException(e.getMessage());

        }

        Log.i("POST", "View conseguiu chamar o metodo PostUsers: ");
    }
}
