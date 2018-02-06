package app.consult.witczak.jakub.com.concultapp.panel.tutor.myStudents.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Student;

public class StudentDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Student student;
    private TextView firstName;
    private TextView lastName;
    private Menu toolbarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        initComponents();
        getStudentObject();
        setToolbar();
        showStudentData();
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
            student.deleteInBackground();
            onBackPressed();
        }
        return true;
    }

    private void initComponents() {
        firstName = findViewById(R.id.student_first_name);
        lastName = findViewById(R.id.student_last_name);
    }

    private void showStudentData() {
        firstName.setText(student.getFirstName());
        lastName.setText(student.getLastName());
    }

    private void getStudentObject() {
        if (getIntent() != null) {
            student = (Student) getIntent().getSerializableExtra("student");
        }
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_details_student);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(student.getFirstName() + " " + student.getLastName());
    }

}
