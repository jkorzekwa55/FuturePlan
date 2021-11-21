package com.example.futureplan;

import android.os.Bundle;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ProfilActivity extends AppCompatActivity {
    private EditText PeditTextEmail;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_profil);

        PeditTextEmail = findViewById(R.id.PeditTextEmail);
        String email = PreferenceUtils.getEmail(this);
        PeditTextEmail.setText(email);
    }
}
