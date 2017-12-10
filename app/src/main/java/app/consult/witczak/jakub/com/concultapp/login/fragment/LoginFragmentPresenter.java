package app.consult.witczak.jakub.com.concultapp.login.fragment;

import com.parse.ParseUser;

import app.consult.witczak.jakub.com.concultapp.utils.UserKey;

/**
 * Created by JakubWitczak on 19.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class LoginFragmentPresenter implements LoginFragmentContract.Presenter {

    private LoginFragmentContract.View view;

    LoginFragmentPresenter(LoginFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void handleLogin() {

        ParseUser.logInInBackground(view.getUsername(), view.getPassword(), (user, e) -> {
            if (user != null) {
                if (user.getBoolean(UserKey.IS_STUDENT)) {
                    view.startStudentPanel();
                } else {
                    view.startTutorPanel();
                }
            } else {
                view.showSnackBar(e.getMessage());
            }
        });
    }
}
