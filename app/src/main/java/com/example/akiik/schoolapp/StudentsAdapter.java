package com.example.akiik.schoolapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.StudentViewHolder> {
    private Context mCtx;
    private List<Student> studentList;


    public StudentsAdapter(Context mCtx,List<Student> studentList){
        this.mCtx=mCtx;
        this.studentList=studentList;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mCtx).inflate(R.layout.recyclerview_student, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
        Student student=studentList.get(position);
        holder.textViewName.setText(student.studentName);
        holder.textViewClass.setText(student.studentClass);
        holder.textViewSection.setText(student.studentSection);
        holder.textViewAttendance.setText(String.valueOf(student.sutAttendance));
        holder.textViewTotal.setText(String.valueOf(student.stuTotal));

    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }


    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName, textViewClass, textViewSection, textViewAttendance,textViewTotal;
        public StudentViewHolder(View itemView){
            super(itemView);

            textViewName=itemView.findViewById(R.id.text_view_name);
            textViewClass=itemView.findViewById(R.id.text_view_class);
            textViewSection=itemView.findViewById(R.id.text_view_section);
            textViewAttendance=itemView.findViewById(R.id.text_view_attendance);
            textViewTotal=itemView.findViewById(R.id.text_view_total);


        }
    }


}
