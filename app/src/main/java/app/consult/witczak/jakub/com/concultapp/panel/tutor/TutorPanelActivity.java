package app.consult.witczak.jakub.com.concultapp.panel.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.parse.ParseUser;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.panel.tutor.myStudents.MyStudentsActivity;
import app.consult.witczak.jakub.com.concultapp.panel.tutor.tasks.TasksForTutorActivity;

public class TutorPanelActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Menu toolbarMenu;
    private Button myStudentsButton;
    private Button tasksToCheckButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_panel);
        setToolbar();
        initComponents();
        setMyStudentsButtonListener();
        setTasksToCheckButtonListener();
    }

    private void setTasksToCheckButtonListener() {
        tasksToCheckButton.setOnClickListener(v -> {
            Intent intent = new Intent(TutorPanelActivity.this, TasksForTutorActivity.class);
            startActivity(intent);
        });
    }

    private void setMyStudentsButtonListener() {
        myStudentsButton.setOnClickListener(v -> {
            Intent intent = new Intent(TutorPanelActivity.this, MyStudentsActivity.class);
            startActivity(intent);
        });
    }

    private void initComponents() {
        myStudentsButton = findViewById(R.id.my_students_button);
        tasksToCheckButton = findViewById(R.id.evaluate_button);
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_tutor_panel);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.tutor_panel);
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
