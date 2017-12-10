package app.consult.witczak.jakub.com.concultapp.login.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.login.fragment.LoginFragment;
import app.consult.witczak.jakub.com.concultapp.model.Student;
import app.consult.witczak.jakub.com.concultapp.model.Task;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnFragmentInteractionListener {

    private Toolbar toolbar;
    private LoginFragment loginFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginFragment = LoginFragment.newInstance();
        setToolbar();
        registerSubclasses();
        parseServerInitialization();
        showLoginFragment();
    }

    private void showLoginFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_login_container, loginFragment)
                .addToBackStack(null)
                .commit();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.Logowanie);
    }

    private void registerSubclasses() {
        ParseObject.registerSubclass(Student.class);
        ParseObject.registerSubclass(Tutor.class);
        ParseObject.registerSubclass(Task.class);
    }

    private void parseServerInitialization() {
        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    @Override
    public void onFragmentInteraction() {
    }
}
