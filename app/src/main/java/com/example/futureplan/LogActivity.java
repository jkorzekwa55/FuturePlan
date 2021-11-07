package com.example.futureplan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogActivity extends AppCompatActivity {
    private Button buttonRejestracja;
    private Button btnLog;
    private EditText editTextEmail, editTextPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        buttonRejestracja = findViewById(R.id.buttonRejestracja);
        buttonRejestracja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LogActivity.this, RegActivity.class));
            }
        });

        btnLog = findViewById(R.id.btnLog);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);

        btnLog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String pass = editTextPassword.getText().toString();

                DataBaseHelper dataBaseHelper = new DataBaseHelper(LogActivity.this);

                boolean checkEmail = dataBaseHelper.checkemail(email);
                boolean checkPassword = dataBaseHelper.checkpassword(email,pass);

                if(checkEmail && checkPassword){
                    Toast.makeText(LogActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LogActivity.this, "Not valid user or password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}