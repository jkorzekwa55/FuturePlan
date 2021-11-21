package com.example.futureplan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {
    private Button buttonLogowanie;
    private Button btnReg;
    private EditText editTextEmail, editTextName, editTextPassword, editTextRepassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        btnReg = findViewById(R.id.btnReg);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextName = findViewById(R.id.editTextName);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextRepassword = findViewById(R.id.editTextPassword2);

        buttonLogowanie = findViewById(R.id.button);
        buttonLogowanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        btnReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = editTextEmail.getText().toString();
                String name = editTextName.getText().toString();
                String pass = editTextPassword.getText().toString();
                String repass = editTextRepassword.getText().toString();
                UserModel userModel;
                DataBaseHelper dataBaseHelper = new DataBaseHelper(RegActivity.this);
                if(email.equals("") || pass.equals("") || repass.equals("")){
                    Toast.makeText(RegActivity.this, "Fill all the fields", Toast.LENGTH_SHORT).show();
                }else{
                    if(pass.equals(repass)){
                        Boolean emailCheckResult = dataBaseHelper.checkemail(email);
                        if(emailCheckResult == false) {
                            try {
                                userModel = new UserModel(-1, editTextName.getText().toString(), editTextEmail.getText().toString(), editTextPassword.getText().toString());
                            } catch (Exception e) {
                                Toast.makeText(RegActivity.this, "Error creating customer", Toast.LENGTH_SHORT).show();
                                userModel = new UserModel(-1, "error", "error", "error");
                            }
                            PreferenceUtils.saveName(name,RegActivity.this);
                            PreferenceUtils.saveEmail(email,RegActivity.this);
                            boolean success = dataBaseHelper.insertData(userModel);
                            Toast.makeText(RegActivity.this, "Success= " + success, Toast.LENGTH_SHORT).show();
                            finish();
                        }else{
                            Toast.makeText(RegActivity.this, "User already exists", Toast.LENGTH_SHORT).show();
                        }


                    }else{
                        Toast.makeText(RegActivity.this, "Not valid password", Toast.LENGTH_SHORT).show();
                    }
                }
                





            }
        });
    }
}