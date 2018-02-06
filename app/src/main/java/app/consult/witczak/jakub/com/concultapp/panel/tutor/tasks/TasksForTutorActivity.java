package app.consult.witczak.jakub.com.concultapp.panel.tutor.tasks;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import app.consult.witczak.jakub.com.concultapp.R;

public class TasksForTutorActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_for_tutor);
        setToolbar();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_tasks_for_tutor);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Do Sprawdzenia");
    }
}
