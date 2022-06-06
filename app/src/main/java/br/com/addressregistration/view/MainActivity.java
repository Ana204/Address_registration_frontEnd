package br.com.addressregistration.view;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.material.textfield.TextInputEditText;
import br.com.addressregistration.R;
import br.com.addressregistration.viewModel.Users;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textInputEditTextName, textInputEditTextEmail,
            textInputEditTextTelephone,textInputEditTextCep;

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
        viewModelUsers.GetRest();

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

                completedForm();

                Log.i("POST", "Button clicado: ");
            }
        });
    }


    public void completedForm(){
       String nameUser = textInputEditTextName.getText().toString();
       String emailUser = textInputEditTextEmail.getText().toString();

        //post request
        viewModelUsers = new Users(getApplicationContext());
        viewModelUsers.PostRest(nameUser, emailUser);

        Log.i("DATA_USER", "completedForm: " + nameUser);
        Log.i("DATA_USER", "completedForm: " + emailUser);
    }
}