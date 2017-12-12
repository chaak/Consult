package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.list.physic;


import android.content.Context;
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

public class PhysicTutorsListFragment extends Fragment implements PhysicTutorsListContract.View {

    private PhysicTutorsListPresenter presenter;
    private RecyclerView recyclerView;
    private TutorsListAdapter adapter;
    private PhysicTutorsListFragmentInteractionWithActivityListener listener;

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
        presenter = new PhysicTutorsListPresenter(this);
        initializeComponents(view);
        setRecyclerView();
        return view;
    }

    private void initializeComponents(View view) {
        recyclerView = view.findViewById(R.id.tutors_list);
    }

    private void setRecyclerView() {
        adapter = new TutorsListAdapter();
        adapter.setOnTutorsListItemClickListener(tutor -> listener.showDetailsFragment(tutor));
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadTutors();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof PhysicTutorsListFragment.PhysicTutorsListFragmentInteractionWithActivityListener) {
            listener = (PhysicTutorsListFragment.PhysicTutorsListFragmentInteractionWithActivityListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement PhysicTutorsListFragmentInteractionWithActivityListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public void refreshView(List<Tutor> tutors) {
        adapter.updateTutorsList(tutors);
    }

    public interface PhysicTutorsListFragmentInteractionWithActivityListener {
        void showDetailsFragment(Tutor tutor);
    }

}
