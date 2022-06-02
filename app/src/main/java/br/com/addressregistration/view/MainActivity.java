package br.com.addressregistration.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;

import java.util.PrimitiveIterator;

import br.com.addressregistration.R;
import br.com.addressregistration.model.FormUsers_model;
import br.com.addressregistration.dominio.api.GetRequestUser;
import br.com.addressregistration.viewModel.Users;
import br.com.addressregistration.viewModel.UsersPost;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextName, textInputEditTextEmail,
            textInputEditTextTelephone,textInputEditTextCep;

    private Button button_enviar;

    private Users viewModelUsers;
    private UsersPost viewModelPost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        StartComponents();
        buttonRegister();

        //get request
        viewModelUsers = new Users(this);
        viewModelUsers.ApiRest();

        viewModelPost = new UsersPost(this);
    }

    public void StartComponents(){
        textInputEditTextName = findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextTelephone = findViewById(R.id.textInputEditTextTelephone);
        textInputEditTextCep = findViewById(R.id.textInputEditTextCep);
        button_enviar = findViewById(R.id.button_enviar);

    }

    private void buttonRegister(){
        button_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //post request
                viewModelPost.PostUsers();
                Log.i("POST", "Button clicado: ");
            }
        });
    }

/*    private void setComponents( ){
        textInputEditTextName.setText();
        textInputEditTextEmail.setText();
        textInputEditTextTelephone.setText();
        textInputEditTextCep.setText();
    }*/
}