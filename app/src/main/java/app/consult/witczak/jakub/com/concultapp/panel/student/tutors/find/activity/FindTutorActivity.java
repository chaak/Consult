package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.adapter.PagerAdapter;

public class FindTutorActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_tutor);
        setToolbar();
        initializeComponents();
        addNewTabs();
        setViewPager();
    }

    private void initializeComponents() {
        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_find_tutor);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.find_tutor);
    }

    private void addNewTabs() {
        tabLayout.addTab(tabLayout.newTab().setText(R.string.math));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.geography));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.biology));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.chemistry));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.physic));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    private void setViewPager() {
        pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
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
}
