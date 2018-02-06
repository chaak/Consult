package app.consult.witczak.jakub.com.concultapp.panel.tutor.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Student;

/**
 * Created by JakubWitczak on 14.01.2018.
 * Copyright (C) Binar::Apps, 2017
 * All rights reserved.
 */
public class MyStudentListAdapter extends RecyclerView.Adapter {

    private List<Student> students = new ArrayList<>();
    private OnStudentListItemClickListener listener;

    public MyStudentListAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_list_item, parent, false);
        return new StudentListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Student student = students.get(position);
        ((MyStudentListAdapter.StudentListViewHolder) holder).background.setOnClickListener(v -> listener.studentsListItemPressed(student));
        ((MyStudentListAdapter.StudentListViewHolder) holder).firstName.setText(student.getFirstName());
        ((MyStudentListAdapter.StudentListViewHolder) holder).lastName.setText(student.getLastName());
    }

    public void updateStudentList(List<Student> students) {
        this.students = students;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return students.size();
    }

    private class StudentListViewHolder extends RecyclerView.ViewHolder {

        View background;
        ImageView profileImage;
        TextView firstName;
        TextView lastName;

        public StudentListViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.students_list_item);
            profileImage = itemView.findViewById(R.id.profile_image);
            firstName = itemView.findViewById(R.id.first_name_label);
            lastName = itemView.findViewById(R.id.last_name_label);
        }
    }

    public void setOnTutorsListItemClickListener(MyStudentListAdapter.OnStudentListItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnStudentListItemClickListener {
        void studentsListItemPressed(Student student);
    }
}
