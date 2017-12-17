package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.io.Serializable;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.adapter.PagerAdapter;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.activity.details.TutorDetailsActivity;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.list.biology.BiologyTutorsListFragment;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.list.chemistry.ChemistryTutorsListFragment;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.list.geography.GeoTutorsListFragment;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.list.math.MathTutorsLisFragment;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.list.physic.PhysicTutorsListFragment;

public class FindTutorActivity extends AppCompatActivity implements
        MathTutorsLisFragment.MathTutorsListFragmentInteractionWithActivityListener,
        GeoTutorsListFragment.GeoTutorsListFragmentInteractionWithActivityListener,
        BiologyTutorsListFragment.BiologyTutorsListFragmentInteractionWithActivityListener,
        PhysicTutorsListFragment.PhysicTutorsListFragmentInteractionWithActivityListener,
        ChemistryTutorsListFragment.ChemistryTutorsListFragmentInteractionWithActivityListener {

    public static final String TUTOR_OBJECT = "tutorObject";
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

    @Override
    protected void onResume() {
        super.onResume();
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

    @Override
    public void showDetailsActivity(Tutor tutor) {
        Intent intent = new Intent(FindTutorActivity.this, TutorDetailsActivity.class);
        intent.putExtra(TUTOR_OBJECT, (Serializable) tutor);
        startActivity(intent);
    }
}
