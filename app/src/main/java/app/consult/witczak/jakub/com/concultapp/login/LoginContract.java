package app.consult.witczak.jakub.com.concultapp.login;

/**
 * Created by JakubWitczak on 12.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public interface LoginContract {

    interface View {

        String getUsername();

        String getPassword();

        void startStudentPanel();

        void startTutorPanel();

    }

    interface Presenter {

        void handleLogin();

    }
}
