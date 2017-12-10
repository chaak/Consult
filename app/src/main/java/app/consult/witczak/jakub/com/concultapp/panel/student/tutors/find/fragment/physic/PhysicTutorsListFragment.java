package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.physic;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import app.consult.witczak.jakub.com.concultapp.R;

public class PhysicTutorsListFragment extends Fragment {

    public static PhysicTutorsListFragment newInstance() {
        return new PhysicTutorsListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutors_list, container, false);
        return view;
    }

}
