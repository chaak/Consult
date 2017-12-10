package app.consult.witczak.jakub.com.concultapp.panel.student.task;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import app.consult.witczak.jakub.com.concultapp.R;

public class TaskActivity extends AppCompatActivity {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        setToolbar();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_tasks);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.tasks);
    }
}
