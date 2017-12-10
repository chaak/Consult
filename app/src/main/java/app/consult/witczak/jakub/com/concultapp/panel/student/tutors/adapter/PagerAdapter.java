package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.PagerAdapterItem;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.biology.BiologyTutorsListFragment;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.chemistry.ChemistryTutorsListFragment;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.geography.GeoTutorsListFragment;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.math.MathTutorsLisFragment;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.fragment.physic.PhysicTutorsListFragment;

/**
 * Created by JakubWitczak on 10.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class PagerAdapter extends FragmentStatePagerAdapter {

    private int numberOfTabs;

    public PagerAdapter(FragmentManager fragmentManager, int numberOfTabs) {
        super(fragmentManager);
        this.numberOfTabs = numberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case PagerAdapterItem.MATH_TAB:
                return new MathTutorsLisFragment();
            case PagerAdapterItem.GEO_TAB:
                return new GeoTutorsListFragment();
            case PagerAdapterItem.BIO_TAB:
                return new BiologyTutorsListFragment();
            case PagerAdapterItem.CHEMISTRY_TAB:
                return new ChemistryTutorsListFragment();
            case PagerAdapterItem.PHYSIC_TAB:
                return new PhysicTutorsListFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return numberOfTabs;
    }
}
