package br.com.addressregistration.viewModel;


import android.content.Context;
import android.util.Log;
import android.widget.Toast;

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
        //Log.i("JSON", "A ViewModel conseguiu chamar o metodo RequestUsers: ");
    }

    //chama endPoint post
    public void viewModel_users(String name, String email, String telephone, String cep,
                                String logradouro, String numeroCasa, String complemento, String bairro, String localidade, String uf){
        user = new DomainUser(this.context);

        try {
            usersModel = new Users_model(name, email, telephone, numeroCasa, cep);
            enderecoModel = new Endereco_model(logradouro, complemento, bairro, localidade, uf);
            user.PostUsers(usersModel, enderecoModel);


        }catch (IllegalArgumentException e){

            throw new IllegalArgumentException(e.getMessage());

        }


    }

/*    public void viewModel_ViaCep(){
        user = new DomainUser(this.context);

        try {
            //usersModel = new Users_model();
            user.getViaCep();

            Log.i("GET", "a view chamou a viewModel: ");
        }catch (IllegalArgumentException e){

            throw new IllegalArgumentException(e.getMessage());
        }
    }*/
}
