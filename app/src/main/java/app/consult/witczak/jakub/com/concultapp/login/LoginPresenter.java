package app.consult.witczak.jakub.com.concultapp.login;

import android.content.Context;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

import app.consult.witczak.jakub.com.concultapp.model.User;

/**
 * Created by JakubWitczak on 12.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private Context context;
    private User user = new User();

    LoginPresenter(LoginContract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

    @Override
    public void handleLogin() {
        ParseUser.logInInBackground(view.getUsername(), view.getPassword(),
                new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (parseUser != null && user != null) {
                            // TODO: 19.11.2017 find tutor or student based on User and assign current user
                            if (user.getIsStudent()) {
                                view.startStudentPanel();
                            } else {
                                view.startTutorPanel();
                            }
                        } else {
                            Toast.makeText(context, "Failed: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

    }
}
