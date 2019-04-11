package com.example.akiik.schoolapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AttendanceFragment extends Fragment {






    DatabaseReference ref;
    private RecyclerView recyclerView;
    private StudentsAdapter adapter;
    private List<Student> studentList;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_attendance, container, false);




        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerview);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));// check

        studentList = new ArrayList<>();

        adapter = new StudentsAdapter(getContext(),studentList);//check

        recyclerView.setAdapter(adapter);





        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String email = user.getEmail();


        //ref = FirebaseDatabase.getInstance().getReference("Students")
        //  Query query=FirebaseDatabase.getInstance().getReference("Parents").orderByValue().equalTo(email);
        Query query = FirebaseDatabase.getInstance().getReference("Students").orderByChild("pemail").equalTo(email);
        query.addListenerForSingleValueEvent(valueEventListener);

        //ref = FirebaseDatabase.getInstance().getReference().child("Students").child("-Lc8ETb9tq6zF7C-YiOE");//ToDo try to use query! !!DONE!!
        //ref this was hit and try method hehehee
        return v;

    }
    ValueEventListener valueEventListener=new ValueEventListener() {
            @Override
            public void onDataChange( DataSnapshot dataSnapshot) {
                studentList.clear();
                        if(dataSnapshot.exists()){
                    for(
                            DataSnapshot snapshot:dataSnapshot.getChildren()){
                        Student student=snapshot.getValue(Student.class);
                        studentList.add(student);
                    }
                    adapter.notifyDataSetChanged();
                        }
            }

            @Override
            public void onCancelled( DatabaseError databaseError) {

            }
        };




}
