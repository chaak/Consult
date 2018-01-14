package app.consult.witczak.jakub.com.concultapp.panel.student.task.activity.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Task;

public class EvaluatedTaskActivity extends AppCompatActivity {

    private Task task;
    private TextView taskTitle;
    private TextView taskDescription;
    private Toolbar toolbar;
    private Menu toolbarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluated_task);
        getTaskObject();
        setToolbar();
        initComponents();
        setComponents();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_details_task);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(task.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.toolbarMenu = menu;
        getMenuInflater().inflate(R.menu.task_details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.delete_button) {
            task.deleteInBackground();
            onBackPressed();
        }
        return true;
    }

    private void setComponents() {
        taskTitle.setText(task.getTitle());
        taskDescription.setText(task.getDescription());
    }

    private void initComponents() {
        taskTitle = findViewById(R.id.task_title);
        taskDescription = findViewById(R.id.task_desc);
    }

    private void getTaskObject() {
        if (getIntent() != null) {
            task = (Task) getIntent().getSerializableExtra("task");
        }
    }
}
