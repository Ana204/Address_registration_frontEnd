package br.com.addressregistration.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import br.com.addressregistration.R;
import br.com.addressregistration.viewModel.Users;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextName, textInputEditTextEmail,
            textInputEditTextTelephone,textInputEditTextCep;
    private TextInputEditText textInputEditTextRua, textInputEditTextHouseNumber, textInputEditTextComplement,
            textInputEditTextCity,textInputEditTextBairro, textInputEditTextUf;

    private Button button_enviar;

    private Users viewModelUsers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        StartComponents();
        buttonRegister();

        //get request
        viewModelUsers = new Users(this);
        viewModelUsers.RequestUsers();

    }

    public void StartComponents(){
        textInputEditTextName = findViewById(R.id.textInputEditTextName);
        textInputEditTextEmail = findViewById(R.id.textInputEditTextEmail);
        textInputEditTextTelephone = findViewById(R.id.textInputEditTextTelephone);
        textInputEditTextCep = findViewById(R.id.textInputEditTextCep);
        textInputEditTextRua = findViewById(R.id.textInputEditTextRua);
        textInputEditTextHouseNumber = findViewById(R.id.textInputEditTextHouseNumber);
        textInputEditTextComplement = findViewById(R.id.textInputEditTextComplement);
        textInputEditTextCity = findViewById(R.id.textInputEditTextCity);
        textInputEditTextBairro = findViewById(R.id.textInputEditTextBairro);
        textInputEditTextUf = findViewById(R.id.textInputEditTextUf);


        button_enviar = findViewById(R.id.button_enviar);

    }

    private void buttonRegister(){
        button_enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                UsersData(view);
                Log.i("POST", "Button clicado: ");
            }
        });
    }


    public void UsersData(View view){
        String name = textInputEditTextName.getText().toString();
        String email = textInputEditTextEmail.getText().toString();
        String telephone = textInputEditTextTelephone.getText().toString();
        String cep = textInputEditTextCep.getText().toString();

        String logradouro = textInputEditTextRua.getText().toString();
        String numeroCasa = textInputEditTextHouseNumber.getText().toString();
        String complemento = textInputEditTextComplement.getText().toString();
        String bairro = textInputEditTextBairro.getText().toString();
        String cidade = textInputEditTextCity.getText().toString();
        String uf = textInputEditTextUf.getText().toString();

        try {
            viewModelUsers.viewModel_users(name, email, telephone, cep, logradouro, numeroCasa, complemento, bairro, cidade, uf);

        }catch (IllegalArgumentException e){

            Snackbar snackbar = Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            snackbar.show();
        }

    }
}