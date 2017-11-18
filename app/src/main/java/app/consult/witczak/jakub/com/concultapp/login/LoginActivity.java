package app.consult.witczak.jakub.com.concultapp.login;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseInstallation;

import app.consult.witczak.jakub.com.concultapp.R;

public class LoginActivity extends AppCompatActivity implements LoginContract.View {

    private LoginPresenter presenter;
    private TextView email;
    private TextView password;
    private TextInputLayout emailInput;
    private TextInputLayout passwordInput;
    private Button signInButton;
    private Button signUpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        presenter = new LoginPresenter(this);
        presenter.registerSubclasses();
        parseServerInitialization();
    }

    private void parseServerInitialization() {
        Parse.initialize(this);
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
