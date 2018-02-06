package app.consult.witczak.jakub.com.concultapp.panel.tutor.myStudents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.io.Serializable;
import java.util.List;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Student;
import app.consult.witczak.jakub.com.concultapp.panel.tutor.adapter.MyStudentListAdapter;
import app.consult.witczak.jakub.com.concultapp.panel.tutor.adapter.MyStudentsContract;
import app.consult.witczak.jakub.com.concultapp.panel.tutor.adapter.MyStudentsPresenter;
import app.consult.witczak.jakub.com.concultapp.panel.tutor.myStudents.details.StudentDetailsActivity;

public class MyStudentsActivity extends AppCompatActivity implements MyStudentsContract.View {

    private Toolbar toolbar;
    private RecyclerView recyclerView;
    private MyStudentListAdapter adapter;
    private MyStudentsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_students);
        recyclerView = findViewById(R.id.my_students_list);
        presenter = new MyStudentsPresenter(this);
        setToolbar();
        setRecyclerView();
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.loadMyTutors();
    }

    private void setRecyclerView() {
        adapter = new MyStudentListAdapter();
        adapter.setOnTutorsListItemClickListener(tutor -> showDetailsActivity(tutor));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(adapter);
    }

    private void showDetailsActivity(Student student) {
        Intent intent = new Intent(MyStudentsActivity.this, StudentDetailsActivity.class);
        intent.putExtra("student", (Serializable) student);
        startActivity(intent);
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_my_students);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.my_students_tutor);
    }

    @Override
    public void refreshView(List<Student> students) {
        adapter.updateStudentList(students);
    }
}
