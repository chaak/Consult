package app.consult.witczak.jakub.com.concultapp.register.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.register.fragment.RegisterFragment;

public class RegisterActivity extends AppCompatActivity implements RegisterFragment.OnFragmentInteractionListener {

    private Toolbar toolbar;
    private Menu toolbarMenu;
    private RegisterFragment registerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        registerFragment = RegisterFragment.newInstance();
        setToolbar();
        showRegisterFragment();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.rejestracja);
    }

    private void showRegisterFragment() {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_register_container, registerFragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.toolbarMenu = menu;
        getMenuInflater().inflate(R.menu.register_toolbar_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_button:
                if (registerFragment.isRegistrationAvailable()){
                    registerFragment.setUserData();
                    registerFragment.handleRegisterUser();
                }
                return true;
            default:
                return true;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
        super.onBackPressed();
    }

    @Override
    public void onFragmentInteraction() {

    }
}
