package app.consult.witczak.jakub.com.concultapp.panel.student.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.parse.ParseUser;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.panel.student.task.TaskActivity;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.activity.FindTutorActivity;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.my.activity.MyTutorsActivity;

public class StudentPanelActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Menu toolbarMenu;
    private Button findTutorButton;
    private Button tasksButton;
    private Button myTutorsButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_panel);
        setToolbar();
        initializeComponents();
        setOnClickListeners();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_student_panel);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.student_panel);
    }

    private void initializeComponents() {
        findTutorButton = findViewById(R.id.find_tutor_button);
        tasksButton = findViewById(R.id.tasks_button);
        myTutorsButton = findViewById(R.id.my_tutors_button);
    }

    private void setOnClickListeners() {
        setFindTutorButtonOnClickListener();
        setTasksButtonOnClickListener();
        setMyTutorsButtonOnClickListener();
    }

    private void setFindTutorButtonOnClickListener() {
        findTutorButton.setOnClickListener(v -> {
            Intent intent = new Intent(StudentPanelActivity.this, FindTutorActivity.class);
            startActivity(intent);
        });
    }

    private void setTasksButtonOnClickListener() {
        tasksButton.setOnClickListener(v -> {
            Intent intent = new Intent(StudentPanelActivity.this, TaskActivity.class);
            startActivity(intent);
        });
    }

    private void setMyTutorsButtonOnClickListener() {
        myTutorsButton.setOnClickListener(v -> {
            Intent intent = new Intent(StudentPanelActivity.this, MyTutorsActivity.class);
            startActivity(intent);
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.toolbarMenu = menu;
        getMenuInflater().inflate(R.menu.panel_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout_button:
                ParseUser.logOut();
                finish();
                return true;
            default:
                return true;
        }
    }
}
