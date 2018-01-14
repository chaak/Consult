package app.consult.witczak.jakub.com.concultapp.panel.student.task.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.io.Serializable;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Task;
import app.consult.witczak.jakub.com.concultapp.panel.student.task.activity.details.EvaluatedTaskActivity;
import app.consult.witczak.jakub.com.concultapp.panel.student.task.adapter.TaskPagerAdapter;
import app.consult.witczak.jakub.com.concultapp.panel.student.task.fragment.list.EvaluatedTaskListFragment;

public class TaskActivity extends AppCompatActivity implements
        EvaluatedTaskListFragment.EvaluatedTaskListFragmentInteractionWithActivityListener {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TaskPagerAdapter taskPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        initializeComponents();
        setToolbar();
        addNewTabs();
        setViewPager();
    }

    private void initializeComponents() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
    }


    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_tasks);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.tasks);
    }

    private void addNewTabs() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.market_label));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.send_task_label));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void setViewPager() {
        taskPagerAdapter = new TaskPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(taskPagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        setOnTabSelectedListener();
    }

    private void setOnTabSelectedListener() {
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void showTaskDetailsActivity(Task task) {
        Intent intent = new Intent(TaskActivity.this, EvaluatedTaskActivity.class);
        intent.putExtra("task", (Serializable) task);
        startActivity(intent);
    }
}
