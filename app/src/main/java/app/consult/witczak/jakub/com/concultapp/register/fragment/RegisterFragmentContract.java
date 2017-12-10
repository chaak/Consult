package app.consult.witczak.jakub.com.concultapp.register.fragment;

import android.app.Activity;

import com.parse.ParseFile;

/**
 * Created by JakubWitczak on 19.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public interface RegisterFragmentContract {

    interface View {

        boolean isSetFirstNameAvailable();

        boolean isSetLastNameAvailable();

        boolean isSetUsernameAvailable();

        boolean isSetEmailAvailable();

        boolean isSetPhoneAvailable();

        boolean isSetPasswordAvailable();

        boolean isSetRepeatPasswordAvailable();

        boolean isSetProfessionAvailable();

        String getBirthDate();

        String getTutorCategory();

        ParseFile getProfileImage();

        boolean getIsStudent();

        void showSnackBar(String message);

        Activity getActivity();

        String getRepeatedPassword();

        String getPassword();

        String getFirstName();

        String getLastName();

        String getUsername();

        String getPhoneNumber();

        String getEmail();

        void startStudentPanel();

        void startTutorPanel();
    }

    interface Presenter {

        void handleRegisterUser();

        boolean isRegistrationAvailable();

        void setUserDetails();
    }
}
