package app.consult.witczak.jakub.com.concultapp.login.fragment;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

/**
 * Created by JakubWitczak on 19.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class LoginFragmentPresenter implements LoginFragmentContract.Presenter {

    public static final String IS_STUDENT = "is_student";
    private LoginFragmentContract.View view;

    LoginFragmentPresenter(LoginFragmentContract.View view) {
        this.view = view;
    }

    @Override
    public void handleLogin() {
        ParseUser.logInInBackground(view.getUsername(), view.getPassword(),
                new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null) {
                            if (parseUser.getBoolean(IS_STUDENT)) {
                                view.startStudentPanel();
                            } else {
                                view.startTutorPanel();
                            }
                        } else {
                            view.showSnackBar(e.getMessage());
                        }
                    }
                });

    }
}
