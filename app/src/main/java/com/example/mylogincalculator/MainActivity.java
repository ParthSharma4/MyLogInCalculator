/* AUTHOR : PARTH SHARMA
YEAR : 2020 Summer
COURSE : SEG 2105*/
package com.example.mylogincalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // initializing variables

    private EditText eName;
    private EditText ePassword;
    private TextView eAttemptsInfo;
    private Button eLogin;

    boolean isValid = false;
    private int counter =5;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor sharedPreferencesEditor;

    private TextView eRegister;
    private CheckBox eRememberMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Linking the variables to the buttons/Textbox

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eAttemptsInfo = findViewById(R.id.tvAttemptsInfo);
        eLogin = findViewById(R.id.btnLogin);
        eRegister = findViewById(R.id.tvRegister);
        eRememberMe = findViewById(R.id.cbRememberMe);

        sharedPreferences = getApplicationContext().getSharedPreferences("CredentialsDataBase", MODE_PRIVATE);
        sharedPreferencesEditor = sharedPreferences.edit();

        if(sharedPreferences!=null){

            String savedUsername = sharedPreferences.getString("Username", "");
            String savedPassword = sharedPreferences.getString("Password", "");

            RegistrationActivity.credentials = new Credentials(savedUsername,savedPassword);

            if(sharedPreferences.getBoolean("RememberMeCheckBox", false)){
                eName.setText(savedUsername);
                ePassword.setText(savedPassword);
                eRememberMe.setChecked(true);
            }
        }

        eRememberMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferencesEditor.putBoolean("RememberMeCheckBox", eRememberMe.isChecked());

                sharedPreferencesEditor.apply();
            }
        });

        eRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, RegistrationActivity.class));
            }
        });

        eLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter the details correctly !", Toast.LENGTH_SHORT).show();
                }else{
                    isValid = validate(inputName, inputPassword);

                    if(!isValid){
                        counter--;
                        Toast.makeText(MainActivity.this, "Incorrect credentials entered !", Toast.LENGTH_SHORT).show();

                        eAttemptsInfo.setText("Number of attempts remaining : "+counter);

                        if(counter==0){

                            eLogin.setEnabled(false);

                        }
                    }else{

                        Toast.makeText(MainActivity.this, "Login successful !", Toast.LENGTH_SHORT).show();

                        // add the code to go to new activity
                        Intent intent = new Intent(MainActivity.this, CalculatorPage.class);
                        startActivity(intent);

                    }
                }

            }
        });
    }

    // A private function to check if the input credentials match the credentials the user used to logIn to

    private boolean validate(String name, String password){

        if(RegistrationActivity.credentials !=null){
            if(name.equals(RegistrationActivity.credentials.getUsername()) && password.equals(RegistrationActivity.credentials.getPassword())){
                return true;
            }
        }

        return false;
    }
}