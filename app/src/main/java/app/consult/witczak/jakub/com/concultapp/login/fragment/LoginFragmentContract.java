package app.consult.witczak.jakub.com.concultapp.login.fragment;

/**
 * Created by JakubWitczak on 19.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public interface LoginFragmentContract {

    interface View {
        String getUsername();

        String getPassword();

        void startStudentPanel();

        void startTutorPanel();

        void showSnackBar(String message);

        void showProgressBar();

        void hideProgessBar();
    }

    interface Presenter {
        void handleLogin();
    }
}
