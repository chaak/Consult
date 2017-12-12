package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;

/**
 * Created by JakubWitczak on 10.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class TutorsListAdapter extends RecyclerView.Adapter {

    private List<Tutor> tutors = new ArrayList<>();
    private OnTutorsListItemClickListener listener;

    public TutorsListAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tutors_list_item, parent, false);
        return new TutorsListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Tutor tutor = tutors.get(position);
        ((TutorsListViewHolder) holder).background.setOnClickListener(v -> listener.tutorsListItemPressed(tutor));
        ((TutorsListViewHolder) holder).firstName.setText(tutor.getFirstName());
        ((TutorsListViewHolder) holder).lastName.setText(tutor.getLastName());
    }

    public void updateTutorsList(List<Tutor> tutors) {
        this.tutors = tutors;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return tutors.size();
    }

    private class TutorsListViewHolder extends RecyclerView.ViewHolder {

        View background;
        ImageView profileImage;
        TextView firstName;
        TextView lastName;

        public TutorsListViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.tutors_list_item);
            profileImage = itemView.findViewById(R.id.profile_image);
            firstName = itemView.findViewById(R.id.first_name_label);
            lastName = itemView.findViewById(R.id.last_name_label);
        }
    }

    public void setOnTutorsListItemClickListener(OnTutorsListItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnTutorsListItemClickListener {
        void tutorsListItemPressed(Tutor tutor);
    }
}
