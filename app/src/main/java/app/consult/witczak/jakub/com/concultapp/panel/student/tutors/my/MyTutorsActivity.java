package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.my;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import app.consult.witczak.jakub.com.concultapp.R;

public class MyTutorsActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_tutors);
        setToolbar();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_my_tutors);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.my_tutors);
    }
}
