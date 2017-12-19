package app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.activity.details;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseObject;
import com.parse.ParseRelation;
import com.parse.ParseUser;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Tutor;
import app.consult.witczak.jakub.com.concultapp.panel.student.tutors.find.defs.UserItems;

public class TutorDetailsActivity extends AppCompatActivity implements TutorDetailsContract.View {

    public static final String TUTOR_OBJECT = "tutorObject";
    public static final String IS_MY_TUTOR_DETAILS = "isMyTutorDetails";
    private Tutor tutor;
    private TextView firstName;
    private TextView lastName;
    private TutorDetailsPresenter presenter;
    private Toolbar toolbar;
    private Menu toolbarMenu;
    private boolean isMyTutorDetails = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_details);
        presenter = new TutorDetailsPresenter(this);
        getTutorObject();
        setToolbar();
        initComponents();
        showTutorsData();
    }

    private void setToolbar() {
        toolbar = findViewById(R.id.toolbar_details_tutor);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(tutor.getTutorsFirstAndLastName());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setNavigationOnClickListener(v -> onBackPressed());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.toolbarMenu = menu;
        getMenuInflater().inflate(R.menu.tutor_details_menu, menu);
        setVisibilityOfDeleteIcon();
        return true;
    }

    private void setVisibilityOfDeleteIcon() {
        if (isMyTutorDetails) {
            setMyTutorDetailToolbar();
        } else {
            setTutorDetailsToolbar(false, true);
        }
    }

    private void setTutorDetailsToolbar(boolean visible, boolean visible2) {
        toolbarMenu.findItem(R.id.ic_delete_forever).setVisible(visible);
        toolbarMenu.findItem(R.id.add_button).setVisible(visible2);
    }

    private void setMyTutorDetailToolbar() {
        setTutorDetailsToolbar(true, false);
        isMyTutorDetails = false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_button:
                // TODO: 17.12.2017 check if there is no the same tutor yet
                ParseRelation<ParseObject> relation = ParseUser.getCurrentUser().getRelation(UserItems.TUTOR_LIST);
                relation.add(tutor);
                ParseUser.getCurrentUser().saveInBackground();
                Toast.makeText(this, tutor.getNewTutorString(), Toast.LENGTH_SHORT).show();
                return true;
            default:
                return true;
        }
    }

    private void showTutorsData() {
        firstName.setText(tutor.getFirstName());
        lastName.setText(tutor.getLastName());
    }

    private void getTutorObject() {
        if (getIntent() != null) {
            tutor = (Tutor) getIntent().getSerializableExtra(TUTOR_OBJECT);
            isMyTutorDetails = getIntent().getBooleanExtra(IS_MY_TUTOR_DETAILS, false);
        }
    }

    private void initComponents() {
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
    }
}
