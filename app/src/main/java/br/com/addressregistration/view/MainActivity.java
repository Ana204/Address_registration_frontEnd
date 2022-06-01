package br.com.addressregistration.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;

import com.google.android.material.textfield.TextInputEditText;

import br.com.addressregistration.R;
import br.com.addressregistration.model.FormUsers_model;
import br.com.addressregistration.dominio.api.GetRequestUser;
import br.com.addressregistration.viewModel.Users;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextName, textInputEditTextEmail,
            textInputEditTextTelephone,textInputEditTextCep;

    private Users viewModelUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        StartComponents();

        //chama a viewModel
        viewModelUsers = new Users(this);
        viewModelUsers.ApiRest();

    }

    public void StartComponents(){
        textInputEditTextName = findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextTelephone = findViewById(R.id.textInputEditTextTelephone);
        textInputEditTextCep = findViewById(R.id.textInputEditTextCep);

    }

/*    private void setComponents( ){
        textInputEditTextName.setText();
        textInputEditTextEmail.setText();
        textInputEditTextTelephone.setText();
        textInputEditTextCep.setText();
    }*/
}