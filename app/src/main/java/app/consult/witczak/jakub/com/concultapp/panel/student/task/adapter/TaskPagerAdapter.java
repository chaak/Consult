package app.consult.witczak.jakub.com.concultapp.panel.student.task.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.consult.witczak.jakub.com.concultapp.panel.student.task.defs.TaskPagerItem;
import app.consult.witczak.jakub.com.concultapp.panel.student.task.fragment.list.EvaluatedTaskListFragment;
import app.consult.witczak.jakub.com.concultapp.panel.student.task.fragment.send.SendTaskFragment;

/**
 * Created by JakubWitczak on 19.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class TaskPagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public TaskPagerAdapter(FragmentManager fragmentManager, int numberOfTabs) {
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case TaskPagerItem.MARKED_TASK:
                return new EvaluatedTaskListFragment();
            case TaskPagerItem.SEND_TASK:
                return new SendTaskFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
