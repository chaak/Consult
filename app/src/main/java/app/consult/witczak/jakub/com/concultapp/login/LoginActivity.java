package app.consult.witczak.jakub.com.concultapp.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Student;
import app.consult.witczak.jakub.com.concultapp.model.Task;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;
import app.consult.witczak.jakub.com.concultapp.model.User;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registerSubclasses();
        parseServerInitialization();
    }

    private void registerSubclasses() {
        ParseObject.registerSubclass(User.class);
        ParseObject.registerSubclass(Student.class);
        ParseObject.registerSubclass(Tutor.class);
        ParseObject.registerSubclass(Task.class);
    }

    private void parseServerInitialization() {
        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
