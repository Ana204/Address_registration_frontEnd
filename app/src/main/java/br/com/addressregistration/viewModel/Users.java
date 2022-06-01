package br.com.addressregistration.viewModel;


import android.content.Context;
import android.util.Log;
import br.com.addressregistration.dominio.api.GetRequestUser;

public class Users {

    private Context context;
    private GetRequestUser requestApi;

    public Users(Context context){
        this.context = context;
    }

    //Chama api
    public void ApiRest(){
        requestApi = new GetRequestUser(this.context);
        requestApi.requestUsers();
        Log.i("JSON", "A ViewModel conseguiu chamar a API: ");
    }
}
