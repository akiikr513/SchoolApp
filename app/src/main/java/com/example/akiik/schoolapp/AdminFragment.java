package com.example.akiik.schoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class AdminFragment extends Fragment {
    private Button butadminlogin;
    private EditText editTextid;
    private EditText editTextpass;
    private FirebaseAuth firebaseAuth;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_admin, container, false);
            firebaseAuth=FirebaseAuth.getInstance();
            editTextid=(EditText)v.findViewById(R.id.adminid) ;
            editTextpass=(EditText)v.findViewById(R.id.adminpass) ;
        butadminlogin = v.findViewById(R.id.but_admin_login);
        butadminlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                adminSignin();


            }
        });
        return v;

    }
    private void adminSignin(){
        String email=editTextid.getText().toString().trim();
        String password=editTextpass.getText().toString().trim();
        if(TextUtils.isEmpty(email)){
            Toast.makeText(getActivity(),"please enter id",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(getActivity(), "please enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Intent iadmindash = new Intent(getActivity(), AdminDash.class);
                startActivity(iadmindash);
                }
                else {
                    Toast.makeText(getActivity(),"enter valid email and password",Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}


//String email=editTextid.getText().toString().trim();
//                String password=editTextpass.getText().toString().trim();
//
//                if(TextUtils.isEmpty(email)){
//                    Toast.makeText(this, "please enter email id", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//
//                if(TextUtils.isEmpty(password)){
//                    Toast.makeText(this, "please enter password", Toast.LENGTH_SHORT).show();
//                    return;
//
//                }
//                firebaseAuth.signInWithEmailAndPassword(email,password);
//Intent iadmindash = new Intent(getActivity(), AdminDash.class);
//                startActivity(iadmindash);
//            }
//        });