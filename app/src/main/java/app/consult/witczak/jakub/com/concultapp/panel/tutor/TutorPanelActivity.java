package app.consult.witczak.jakub.com.concultapp.panel.tutor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import com.parse.ParseUser;

import app.consult.witczak.jakub.com.concultapp.R;

public class TutorPanelActivity extends AppCompatActivity {

    private Button logoutButton;
    private Toolbar toolbar;
    private Menu toolbarMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_panel);
        setToolbar();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_tutor_panel);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.tutor_panel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.toolbarMenu = menu;
        getMenuInflater().inflate(R.menu.panel_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.logout_button:
                ParseUser.logOut();
                finish();
                return true;
            default:
                return true;
        }
    }
}
