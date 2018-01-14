package app.consult.witczak.jakub.com.concultapp.panel.student.task.fragment.send;

/**
 * Created by JakubWitczak on 19.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class SendTaskFragmentPresenter implements SendTaskFragmentContract.Presenter {

    private SendTaskFragmentContract.View view;

    public SendTaskFragmentPresenter(SendTaskFragmentContract.View view) {
        this.view = view;
    }
}
