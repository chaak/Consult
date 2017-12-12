package app.consult.witczak.jakub.com.concultapp.register.fragment;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseFile;

import java.util.Calendar;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.panel.student.main.StudentPanelActivity;
import app.consult.witczak.jakub.com.concultapp.panel.tutor.TutorPanelActivity;

public class RegisterFragment extends Fragment implements RegisterFragmentContract.View {

    public static final String KOREPETYTOR = "Korepetytor";
    private OnFragmentInteractionListener listener;
    private RegisterFragmentPresenter presenter;

    private EditText firstName;
    private EditText lastName;
    private EditText password;
    private EditText repeatPassword;
    private EditText email;
    private EditText phoneNumber;
    private EditText username;

    private TextInputLayout firstNameTextInput;
    private TextInputLayout lastNameTextInput;
    private TextInputLayout passwordTextInput;
    private TextInputLayout repeatPasswordTextInput;
    private TextInputLayout emailTextInput;
    private TextInputLayout phoneNumberTextInput;
    private TextInputLayout usernameTextInput;

    private RadioGroup radioButtonProfessionGroup;
    private RadioButton professionRadioButton;
    private Spinner categorySpinner;
    private Button changeBirthdayButton;
    private ImageView profileImage;
    private FloatingActionButton addProfileImageButton;

    private static TextView birthDate;
    private ArrayAdapter<CharSequence> adapter;
    private String selectedCategory;
    private TextView category;
    private boolean isStudent;
    private FrameLayout frameLayout;

    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);
        presenter = new RegisterFragmentPresenter(this);
        initializeComponents(view);
        return view;
    }

    private void initializeComponents(View view) {
        initializeEditText(view);
        initializeTextInputLayout(view);
        initializeOtherComponents(view);
    }

    private void initializeTextInputLayout(View view) {
        firstNameTextInput = view.findViewById(R.id.first_name_input_layout);
        lastNameTextInput = view.findViewById(R.id.last_name_input_layout);
        passwordTextInput = view.findViewById(R.id.password_input_layout);
        repeatPasswordTextInput = view.findViewById(R.id.repeat_password_input_layout);
        emailTextInput = view.findViewById(R.id.email_input_layout);
        phoneNumberTextInput = view.findViewById(R.id.phone_number_input_layout);
        usernameTextInput = view.findViewById(R.id.username_input_layout);
    }

    private void initializeOtherComponents(View view) {
        radioButtonProfessionGroup = view.findViewById(R.id.radio_button_profession);
        categorySpinner = view.findViewById(R.id.category_spinner);
        changeBirthdayButton = view.findViewById(R.id.change_date_of_birth);
        profileImage = view.findViewById(R.id.profile_image);
        addProfileImageButton = view.findViewById(R.id.add_profile_photo);
        birthDate = view.findViewById(R.id.date_of_birth);
        category = view.findViewById(R.id.category_label);
        frameLayout = view.findViewById(R.id.frame_layout_register);
    }

    private void initializeEditText(View view) {
        firstName = view.findViewById(R.id.first_name);
        lastName = view.findViewById(R.id.last_name);
        password = view.findViewById(R.id.password_text_edit);
        repeatPassword = view.findViewById(R.id.repeat_password_text_edit);
        email = view.findViewById(R.id.email_text_edit);
        phoneNumber = view.findViewById(R.id.phone_number_text_edit);
        username = view.findViewById(R.id.username);
    }

    @Override
    public void onResume() {
        super.onResume();
        setJobsSpinner();
        setOnTextChangeListener();
        setOnCheckedListener();
        setOnItemSelectedListener();
        setOnClickChangeBirthDateButtonListener();
    }

    private void setJobsSpinner() {
        adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.categoryItems, android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
        categorySpinner.setVisibility(View.GONE);
        category.setVisibility(View.GONE);

    }

    private void setOnTextChangeListener() {
        setOnTextChangedListener(firstName, firstNameTextInput);
        setOnTextChangedListener(lastName, lastNameTextInput);
        setOnTextChangedListener(email, emailTextInput);
        setOnTextChangedListener(phoneNumber, phoneNumberTextInput);
        setOnTextChangedListener(password, passwordTextInput);
        setOnTextChangedListener(repeatPassword, repeatPasswordTextInput);
    }

    private void setOnCheckedListener() {
        radioButtonProfessionGroup.setOnCheckedChangeListener((radioGroup, i) -> {
            professionRadioButton = radioGroup.findViewById(i);
            setVisibilityOfCategorySpinner();
        });
    }

    private void setVisibilityOfCategorySpinner() {
        if (professionRadioButton.getText().equals(KOREPETYTOR)) {
            categorySpinner.setVisibility(View.VISIBLE);
            category.setVisibility(View.VISIBLE);
            isStudent = false;
        } else {
            categorySpinner.setVisibility(View.GONE);
            category.setVisibility(View.GONE);
            isStudent = true;
        }
    }

    private void setOnTextChangedListener(EditText editText, final TextInputLayout inputLayout) {
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editable.toString().isEmpty()) {
                    inputLayout.setErrorEnabled(false);
                }
            }
        });
    }

    private void setOnItemSelectedListener() {
        categorySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedCategory = categorySpinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void setOnClickChangeBirthDateButtonListener() {
        changeBirthdayButton.setOnClickListener(view -> showDatePicker());
    }

    private void showDatePicker() {
        Calendar c = java.util.Calendar.getInstance();
        int year = c.get(java.util.Calendar.YEAR);
        int month = c.get(java.util.Calendar.MONTH);
        int day = c.get(java.util.Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
                (datePicker, i, i1, i2) -> showDate(i, i1, i2), year, month, day);
        datePickerDialog.show();
    }

    public static void showDate(int year, int month, int day) {
        birthDate.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    private boolean isTextInputLayoutEmpty(TextInputLayout inputLayout) {
        return inputLayout.getEditText().getText().toString().trim().isEmpty();
    }

    private String getTextFromTextInputLayout(TextInputLayout inputLayout) {
        return inputLayout.getEditText().getText().toString().trim();
    }

    @Override
    public boolean isSetFirstNameAvailable() {
        if (isTextInputLayoutEmpty(firstNameTextInput)) {
            firstNameTextInput.setError(getString(R.string.imie_wymagane));
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isSetLastNameAvailable() {
        if (isTextInputLayoutEmpty(lastNameTextInput)) {
            lastNameTextInput.setError(getString(R.string.nazwisko_wymagane));
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isSetEmailAvailable() {
        if (isTextInputLayoutEmpty(emailTextInput)) {
            emailTextInput.setError(getString(R.string.email_wymagany));
            return false;
        } else if (!isValidEmail(getTextFromTextInputLayout(emailTextInput))) {
            emailTextInput.setError(getString(R.string.nieprawydlowy_email));
            return false;
        } else {
            return true;
        }
    }

    public static boolean isValidEmail(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    @Override
    public boolean isSetPhoneAvailable() {
        if (isTextInputLayoutEmpty(phoneNumberTextInput)) {
            phoneNumberTextInput.setError(getString(R.string.telefon_wymagany));
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean isSetPasswordAvailable() {
        if (isTextInputLayoutEmpty(passwordTextInput)) {
            passwordTextInput.setError(getString(R.string.haslo_wymagane));
            return false;
        } else {
            getPassword();
            return true;
        }
    }

    @Override
    public boolean isSetRepeatPasswordAvailable() {
        if (isTextInputLayoutEmpty(repeatPasswordTextInput)) {
            repeatPasswordTextInput.setError(getString(R.string.powtorz_haslo_wymagane));
            return false;
        } else {
            getRepeatedPassword();
            return true;
        }
    }

    @Override
    public boolean isSetProfessionAvailable() {
        if (professionRadioButton == null) {
            Toast.makeText(getContext(), R.string.wybierz_profesje, Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public boolean isSetUsernameAvailable() {
        if (isTextInputLayoutEmpty(usernameTextInput)) {
            usernameTextInput.setError(getString(R.string.nazwa_uzwytkownika_wymagana));
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getBirthDate() {
        return birthDate.getText().toString();
    }

    @Override
    public String getTutorCategory() {
        return selectedCategory;
    }

    @Override
    public ParseFile getProfileImage() {
        return null;
    }

    @Override
    public boolean getIsStudent() {
        return isStudent;
    }

    @Override
    public void showSnackBar(String message) {
        Snackbar snackbar = Snackbar
                .make(frameLayout, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public String getRepeatedPassword() {
        return getTextFromTextInputLayout(repeatPasswordTextInput);
    }

    @Override
    public String getPassword() {
        return getTextFromTextInputLayout(passwordTextInput);
    }

    @Override
    public String getFirstName() {
        return getTextFromTextInputLayout(firstNameTextInput);
    }

    @Override
    public String getLastName() {
        return getTextFromTextInputLayout(lastNameTextInput);
    }

    @Override
    public String getUsername() {
        return getTextFromTextInputLayout(usernameTextInput);
    }

    @Override
    public String getPhoneNumber() {
        return getTextFromTextInputLayout(phoneNumberTextInput);
    }

    @Override
    public String getEmail() {
        return getTextFromTextInputLayout(emailTextInput);
    }

    @Override
    public void startStudentPanel() {
        Intent intent = new Intent(getContext(), StudentPanelActivity.class);
        startActivity(intent);
    }

    @Override
    public void startTutorPanel() {
        Intent intent = new Intent(getContext(), TutorPanelActivity.class);
        startActivity(intent);
    }

    public boolean isRegistrationAvailable() {
        return presenter.isRegistrationAvailable();
    }

    public void handleRegisterUser() {
        presenter.handleRegisterUser();
    }


    public void setUserData() {
        presenter.setUserDetails();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnTutorsDetailsFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction();
    }

}
