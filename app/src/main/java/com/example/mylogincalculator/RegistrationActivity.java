package com.example.mylogincalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistrationActivity extends AppCompatActivity {

    // Initializing variables

    private EditText eRegName;
    private EditText eRegPassword;
    private Button eRegister;

    public static Credentials credentials;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferenceEditor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        eRegName = findViewById(R.id.etRegName);
        eRegPassword = findViewById(R.id.etRegPassword);
        eRegister = findViewById(R.id.btnRegister);
        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDataBase", MODE_PRIVATE);
        sharedPreferenceEditor = sharedPreferences.edit();



        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String regUsername = eRegName.getText().toString();
                String regPassword = eRegPassword.getText().toString();

                if(validate(regUsername,regPassword)){
                    credentials = new Credentials(regUsername, regPassword);

                    // to store the credentials

                    sharedPreferenceEditor.putString("Username", regUsername);
                    sharedPreferenceEditor.putString("Password", regPassword);

                    // Commits the changes and adds them to the file
                    sharedPreferenceEditor.apply();

                    startActivity(new Intent(RegistrationActivity.this, MainActivity.class));
                    Toast.makeText(RegistrationActivity.this, "Registration Successful", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    // A private function to check if the input credentials match the credentials the user used to logIn to

    private boolean validate(String username, String password){

        if(username.isEmpty() || password.length()<7){
            Toast.makeText(this, "Please enter all the details, password should be more than 7 characters", Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }
}