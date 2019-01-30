package com.example.akiik.schoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class AccountantFragment extends Fragment {
    Button but;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_accountant, container, false);

        but = v.findViewById(R.id.but_acc_login);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent iaccdash = new Intent(getActivity(), AccountantDash.class);
                startActivity(iaccdash);
            }
        });
        return v;
    }
}
