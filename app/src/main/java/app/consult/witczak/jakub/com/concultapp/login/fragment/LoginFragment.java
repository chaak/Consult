package app.consult.witczak.jakub.com.concultapp.login.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.panel.student.main.StudentPanelActivity;
import app.consult.witczak.jakub.com.concultapp.panel.tutor.TutorPanelActivity;
import app.consult.witczak.jakub.com.concultapp.register.activity.RegisterActivity;

public class LoginFragment extends Fragment implements LoginFragmentContract.View {

    private LoginFragmentPresenter presenter;
    private TextView username;
    private TextView password;
    private TextInputLayout usernameInput;
    private TextInputLayout passwordInput;
    private Button signInButton;
    private Button signUpButton;
    private ConstraintLayout constraintLayout;
    private OnFragmentInteractionListener listener;
    private ProgressDialog dialog;

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        presenter = new LoginFragmentPresenter(this);
        initializeComponents(view);
        setSignInButtonListeners();
        setSignUpButtonListeners();
        return view;
    }

    private void initializeComponents(View view) {
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        passwordInput = view.findViewById(R.id.text_input_password);
        usernameInput = view.findViewById(R.id.text_input_username);
        signInButton = view.findViewById(R.id.sign_in_button);
        signUpButton = view.findViewById(R.id.sign_up_button);
        constraintLayout = view.findViewById(R.id.constraint_layout_login);
    }

    private void setSignInButtonListeners() {
        signInButton.setOnClickListener(v -> presenter.handleLogin());
    }

    private void setSignUpButtonListeners() {
        signUpButton.setOnClickListener(v -> startRegisterActivity());
    }

    private void startRegisterActivity() {
        Intent intent = new Intent(getContext(), RegisterActivity.class);
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
        Intent intent = new Intent(getContext(), StudentPanelActivity.class);
        startActivity(intent);
    }

    @Override
    public void startTutorPanel() {
        Intent intent = new Intent(getContext(), TutorPanelActivity.class);
        startActivity(intent);
    }

    @Override
    public void showSnackBar(String message) {
        Snackbar snackbar = Snackbar
                .make(constraintLayout, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    @Override
    public void showProgressBar() {
        dialog = ProgressDialog.show(getActivity(), "",
                "Logging. Please wait...", true);
    }

    @Override
    public void hideProgessBar() {
        dialog.cancel();
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
