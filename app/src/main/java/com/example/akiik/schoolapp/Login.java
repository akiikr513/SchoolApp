package com.example.akiik.schoolapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {
    private Button login_but;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private TextView textViewReset;
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        login_but = (Button) findViewById(R.id.login_but);
        editTextEmail = (EditText) findViewById(R.id.p_id);
        editTextPassword = (EditText) findViewById(R.id.p_pass);
        textViewReset = (TextView) findViewById(R.id.resetpass);

        firebaseAuth = FirebaseAuth.getInstance();

        login_but.setOnClickListener(this);
        textViewReset.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == login_but) {
            pLogin();
        }
        if (v == textViewReset) {
            Toast.makeText(this, "Password sent to registered no.", Toast.LENGTH_SHORT).show();
        }

    }

    private void pLogin() {
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "please enter id", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    Intent iwell = new Intent(Login.this, wellcome.class);
                    startActivity(iwell);
                    finish();
                }
                else {
                    Toast.makeText(Login.this,"enter valid email and password",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
