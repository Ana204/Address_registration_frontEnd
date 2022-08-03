package br.com.addressregistration.viewModel;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import br.com.addressregistration.dominio.api.DomainUser;
import br.com.addressregistration.model.Endereco_model;
import br.com.addressregistration.model.Users_model;

public class Users {

    private Context context;
    private DomainUser user;
    Users_model usersModel;
    Endereco_model enderecoModel;

    public Users(Context context){
        this.context = context;
    }

    //Chama api
    public void RequestUsers(){
        user = new DomainUser(this.context);
        user.GetUsers();
    }

    //chama endPoint post
    public void viewModel_users(String name, String email, String telephone, String cep,
                                String logradouro, String numeroCasa, String complemento, String bairro, String localidade, String uf){
        try {
            user = new DomainUser(this.context);
            usersModel = new Users_model(name, email, telephone, numeroCasa, cep);
            enderecoModel = new Endereco_model(logradouro, complemento, bairro, localidade, uf);

            user.PostUsers(usersModel, enderecoModel);

        }catch (IllegalArgumentException e){

            throw new IllegalArgumentException(e.getMessage());

        }
    }

}
