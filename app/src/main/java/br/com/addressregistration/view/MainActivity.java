package br.com.addressregistration.view;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import br.com.addressregistration.R;
import br.com.addressregistration.dominio.api.DomainUser;
import br.com.addressregistration.model.APICallback;
import br.com.addressregistration.model.Endereco_model;
import br.com.addressregistration.model.Users_model;
import br.com.addressregistration.viewModel.Users;

public class MainActivity extends AppCompatActivity{

    private TextInputEditText textInputEditTextName, textInputEditTextEmail,
            textInputEditTextTelephone,textInputEditTextCep;
    private TextInputEditText textInputEditTextRua, textInputEditTextHouseNumber, textInputEditTextComplement,
            textInputEditTextCity,textInputEditTextBairro, textInputEditTextUf;

    private Button button_enviar;

    private Users viewModelUsers;
    private DomainUser domainUser;
    private Users_model usersModel;

    Endereco_model enderecoModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        StartComponents();
        buttonRegister();
        textListenerCep();

        //get request
        viewModelUsers = new Users(this);
       // viewModelUsers.RequestUsers();

        domainUser = new DomainUser(this);
    }

    public void textListenerCep(){
        textInputEditTextCep.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence.length() == 9){
                    String cep = textInputEditTextCep.getText().toString();
                    domainUser.getViaCep(cep);

                    APICallback callback = new APICallback() {
                        @Override
                        public void onSuccess(Endereco_model enderecoModel) {
                            textInputEditTextRua.setText(enderecoModel.getLogradouro());
                            textInputEditTextComplement.setText(enderecoModel.getComplemento());
                            textInputEditTextCity.setText(enderecoModel.getLocalidade());
                            textInputEditTextBairro.setText(enderecoModel.getBairro());
                            textInputEditTextUf.setText(enderecoModel.getUf());
                        }

                        @Override
                        public void onError(String error) {
                            Log.i("GET", "onError: " + error);
                        }
                    };
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

/*    public void setComponentes(){

        APICallback callback = new APICallback() {
            @Override
            public void onSuccess(Endereco_model enderecoModel) {

            }

            @Override
            public void onError(String error) {
                Log.i("GET", "onError: " + error);
            }
        };

    }*/

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
        String localidade = textInputEditTextCity.getText().toString();
        String uf = textInputEditTextUf.getText().toString();

        try {
            viewModelUsers.viewModel_users(name, email, telephone, cep, logradouro, numeroCasa, complemento, bairro, localidade, uf);

        }catch (IllegalArgumentException e){

            Snackbar snackbar = Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG);
            snackbar.setBackgroundTint(Color.WHITE);
            snackbar.setTextColor(Color.BLACK);
            snackbar.show();
        }

    }
}