package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.my.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.io.Serializable;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.activity.details.TutorDetailsActivity;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.my.list.MyTutorsListFragment;

public class MyTutorsActivity extends AppCompatActivity implements
        MyTutorsListFragment.MyTutorsListFragmentInteractionWithActivityListener {

    public static final String TUTOR_OBJECT = "tutorObject";
    public static final String IS_MY_TUTOR_DETAILS = "isMyTutorDetails";
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tutors);
        setToolbar();
        showMyTutorsListFragment();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_my_tutors);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.my_tutors);
    }

    private void showMyTutorsListFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.my_tutors_fragment_container, MyTutorsListFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showDetailsActivity(Tutor tutor) {
        Intent intent = new Intent(MyTutorsActivity.this, TutorDetailsActivity.class);
        intent.putExtra(TUTOR_OBJECT, (Serializable) tutor);
        intent.putExtra(IS_MY_TUTOR_DETAILS, true);
        startActivity(intent);
    }
}
