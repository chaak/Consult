package app.consult.witczak.jakub.com.concultapp.panel.student.task.defs;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;

import static app.consult.witczak.jakub.com.concultapp.panel.student.task.defs.TaskPagerItem.MARKED_TASK;
import static app.consult.witczak.jakub.com.concultapp.panel.student.task.defs.TaskPagerItem.SEND_TASK;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by JakubWitczak on 19.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
@Retention(SOURCE)
@IntDef({MARKED_TASK, SEND_TASK})
public @interface TaskPagerItem {
    int MARKED_TASK = 0;
    int SEND_TASK = 1;
}
