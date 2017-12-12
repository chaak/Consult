package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.geography;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.adapter.TutorsListAdapter;

public class GeoTutorsListFragment extends Fragment implements GeoTutorsListContract.View {

    private GeoTutorsListPresenter presenter;
    private RecyclerView recyclerView;
    private TutorsListAdapter adapter;

    public static GeoTutorsListFragment newInstance() {
        return new GeoTutorsListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutors_list, container, false);
        presenter = new GeoTutorsListPresenter(this);
        initializeComponents(view);
        return view;
    }

    private void initializeComponents(View view) {
        recyclerView = view.findViewById(R.id.tutors_list);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadTutors();
    }

    @Override
    public void refreshView(List<Tutor> tutors) {
        adapter = new TutorsListAdapter(tutors, recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
}
