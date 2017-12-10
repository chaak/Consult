package app.consult.witczak.jakub.com.concultapp.register.fragment;

import android.widget.Toast;

import com.parse.ParseUser;

import java.util.Objects;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Student;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;
import app.consult.witczak.jakub.com.concultapp.utils.UserKey;

/**
 * Created by JakubWitczak on 19.11.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class RegisterFragmentPresenter implements RegisterFragmentContract.Presenter {

    private RegisterFragmentContract.View view;
    private ParseUser parseUser = new ParseUser();
    private Student student = new Student();
    private Tutor tutor = new Tutor();

    RegisterFragmentPresenter(RegisterFragmentContract.View view) {
        this.view = view;
    }


    @Override
    public void handleRegisterUser() {
        parseUser.signUpInBackground(e -> {
            if (e == null) {
                if (view.getIsStudent()) {
                    setStudent(student);
                    view.startStudentPanel();
                } else {
                    setTutor(tutor);
                    view.startTutorPanel();
                }
            } else {
                Toast.makeText(view.getActivity(), e.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setStudent(Student student) {
        student.setFirstName(view.getFirstName());
        student.setLastName(view.getLastName());
        student.setUserName(view.getUsername());
        student.setEmail(view.getEmail());
        student.setPhoneNumber(view.getPhoneNumber());
        student.setBirthday(view.getBirthDate());
        student.saveInBackground();
    }


    private void setTutor(Tutor tutor) {
        tutor.setFirstName(view.getFirstName());
        tutor.setLastName(view.getLastName());
        tutor.setUserName(view.getUsername());
        tutor.setEmail(view.getEmail());
        tutor.setPhoneNumber(view.getPhoneNumber());
        tutor.setBirthday(view.getBirthDate());
        tutor.setCategory(view.getTutorCategory());
        tutor.saveInBackground();
    }

    @Override
    public boolean isRegistrationAvailable() {
        return view.isSetFirstNameAvailable() && view.isSetLastNameAvailable()
                && view.isSetUsernameAvailable() && view.isSetPasswordAvailable()
                && view.isSetRepeatPasswordAvailable() && view.isSetEmailAvailable()
                && view.isSetPhoneAvailable() && view.isSetProfessionAvailable();
    }

    @Override
    public void setUserDetails() {
        parseUser.setUsername(view.getUsername());
        parseUser.setEmail(view.getEmail());
        setUserPassword();
        parseUser.put(UserKey.FIRST_NAME, view.getFirstName());
        parseUser.put(UserKey.LAST_NAME, view.getLastName());
        parseUser.put(UserKey.PHONE_NUMBER, view.getPhoneNumber());
        parseUser.put(UserKey.BIRTHDAY, view.getBirthDate());
        parseUser.put(UserKey.IS_STUDENT, view.getIsStudent());
        setTutorCategory(view.getTutorCategory());
        // TODO: 25.11.2017 implement adding profile images
//        parseUser.put("profile_image", view.getProfileImage());
    }

    private void setUserPassword() {
        if (Objects.equals(view.getRepeatedPassword(), view.getPassword())) {
            parseUser.setPassword(view.getPassword());
        } else {
            view.showSnackBar(view.getActivity().getString(R.string.hasla_niepasuja));
        }
    }

    private void setTutorCategory(String category) {
        if (!view.getIsStudent()) {
            parseUser.put(UserKey.CATEGORY, category);
        }
    }
}
