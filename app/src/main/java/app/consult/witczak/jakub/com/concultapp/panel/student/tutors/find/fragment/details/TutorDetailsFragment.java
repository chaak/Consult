package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.details;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;

public class TutorDetailsFragment extends Fragment implements TutorDetailsContract.View {

    private static final String TUTOR_OBJECT = "tutorObject";
    private Tutor tutor;
    private TutorDetailsPresenter presenter;
    private TextView firstName;
    private TextView lastName;

    public static TutorDetailsFragment newInstance(Tutor tutor) {
        TutorDetailsFragment fragment = new TutorDetailsFragment();
        Bundle args = new Bundle();
        args.putSerializable(TUTOR_OBJECT, tutor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.tutor = (Tutor) getArguments().getSerializable(TUTOR_OBJECT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tutor_details, container, false);
        presenter = new TutorDetailsPresenter(this);
        initializeComponents(view);

        firstName.setText(tutor.getFirstName());
        lastName.setText(tutor.getLastName());
        return view;
    }

    private void initializeComponents(View view) {
        firstName = view.findViewById(R.id.tutor_first_name);
        lastName = view.findViewById(R.id.tutor_last_name);
    }
}
