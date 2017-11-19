package app.consult.witczak.jakub.com.concultapp.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Student;
import app.consult.witczak.jakub.com.concultapp.model.Task;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;
import app.consult.witczak.jakub.com.concultapp.model.User;
import app.consult.witczak.jakub.com.concultapp.panel.student.StudentPanelActivity;
import app.consult.witczak.jakub.com.concultapp.panel.tutor.TutorPanelActivity;
import app.consult.witczak.jakub.com.concultapp.register.activity.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginPresenter presenter;
    private TextView username;
    private TextView password;
    private TextInputLayout usernameInput;
    private TextInputLayout passwordInput;
    private Button signInButton;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registerSubclasses();
        parseServerInitialization();
        presenter = new LoginPresenter(this, getApplicationContext());
        initializeComponents();
        setSignInButtonListeners();
        setSignUpButtonListeners();
    }

    private void registerSubclasses() {
        ParseObject.registerSubclass(User.class);
        ParseObject.registerSubclass(Student.class);
        ParseObject.registerSubclass(Tutor.class);
        ParseObject.registerSubclass(Task.class);
    }

    private void initializeComponents() {
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        passwordInput = findViewById(R.id.text_input_password);
        usernameInput = findViewById(R.id.text_input_username);
        signInButton = findViewById(R.id.sign_in_button);
        signUpButton = findViewById(R.id.sign_up_button);
    }

    private void parseServerInitialization() {
        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }

    private void setSignInButtonListeners() {
        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.handleLogin();
            }
        });
    }

    private void setSignUpButtonListeners() {
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startRegisterActivity();
            }
        });
    }

    private void startRegisterActivity() {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void startStudentPanel() {
        Intent intent = new Intent(this, StudentPanelActivity.class);
        startActivity(intent);
    }

    @Override
    public void startTutorPanel() {
        Intent intent = new Intent(this, TutorPanelActivity.class);
        startActivity(intent);
    }
}
