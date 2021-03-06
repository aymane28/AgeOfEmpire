package com.example.ageofempire.user;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.AgeofEmpire.R;
import com.example.ageofempire.view.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Register extends AppCompatActivity {
    EditText mNom, mPrenom, mEmail, mMotDePasse;
    Button mRegisterBtn;
    TextView mLoginBtn;
    FirebaseAuth mAuth;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mNom = findViewById(R.id.Nom);
        mPrenom = findViewById(R.id.Prenom);
        mEmail = findViewById(R.id.Email);
        mMotDePasse = findViewById(R.id.MotDePasse);
        mRegisterBtn = findViewById(R.id.registerBtn);
        mLoginBtn = findViewById(R.id.createText);

        mAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.progressBar);


        //verification si compte deja créer ou pas

        if (mAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }


        mRegisterBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = mEmail.getText().toString().trim();
                String motdepasse = mMotDePasse.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    mEmail.setError("Veuillez remplir toutes les cases");
                    return;
                }

                if (TextUtils.isEmpty(motdepasse)) {
                    mMotDePasse.setError("Veuillez remplir toutes les cases");
                    return;
                }

                if (motdepasse.length() < 6) {
                    mMotDePasse.setError("Votre mot de passe doit contenir plus de 6 caractères au minimum");
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);


                //enregistrement de l'utisateur dans Firebase

                mAuth.createUserWithEmailAndPassword(email, motdepasse).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Register.this, "Utilisateur crée", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }
                        else {
                            Toast.makeText(Register.this, "Erreur !" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                        }
                    }
                });
            }
        });


        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Login.class)); // va à la page de connexion
            }
        });

    }
}