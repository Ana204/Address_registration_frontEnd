package br.com.addressregistration.viewModel;

import android.content.Context;
import android.util.Log;

import br.com.addressregistration.dominio.api.PostRequestUser;

public class UsersPost {

    Context context;
    PostRequestUser requestUser;

    public UsersPost(Context context) {
        this.context = context;
    }

    //chama endPoint post
     public void PostUsers(){
        requestUser = new PostRequestUser(this.context);
        requestUser.RequestUsers();
         Log.i("POST", "View conseguiu chamar a ViewModel: ");
     }
}
