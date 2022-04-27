package br.com.addressregistration.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import br.com.addressregistration.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
    }
}