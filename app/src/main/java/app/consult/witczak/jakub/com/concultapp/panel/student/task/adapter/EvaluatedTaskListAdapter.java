package app.consult.witczak.jakub.com.concultapp.panel.student.task.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Task;

/**
 * Created by JakubWitczak on 19.12.2017.
 * Copyright (C), 2017
 * All rights reserved.
 */
public class EvaluatedTaskListAdapter extends RecyclerView.Adapter {

    private List<Task> evaluatedTasks = new ArrayList<>();
    private OnEvaluatedTaskListItemClickListener listener;

    public EvaluatedTaskListAdapter() {
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.evaluated_task_list_item, parent, false);
        return new EvaluatedTaskListAdapter.TaskListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Task task = evaluatedTasks.get(position);
        ((EvaluatedTaskListAdapter.TaskListViewHolder) holder).category.setText(task.getCategory());
        ((EvaluatedTaskListAdapter.TaskListViewHolder) holder).title.setText(task.getTitle());
        ((EvaluatedTaskListAdapter.TaskListViewHolder) holder).background.setOnClickListener(v -> listener.tasksListItemPressed(task));
//        ((TaskListViewHolder) holder).taskMiniature.setImageResource(task.getTaskImage());
    }

    public void updateTaskList(List<Task> tasks) {
        this.evaluatedTasks = tasks;
        notifyDataSetChanged();
    }


    @Override
    public int getItemCount() {
        return evaluatedTasks.size();
    }

    private class TaskListViewHolder extends RecyclerView.ViewHolder {

        View background;
        ImageView taskMiniature;
        TextView category;
        TextView title;

        TaskListViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.background);
            taskMiniature = itemView.findViewById(R.id.task_miniature);
            category = itemView.findViewById(R.id.category);
            title = itemView.findViewById(R.id.title_text_edit);
        }
    }

    public void setOnTutorsListItemClickListener(OnEvaluatedTaskListItemClickListener listener) {
        this.listener = listener;
    }

    public interface OnEvaluatedTaskListItemClickListener {
        void tasksListItemPressed(Task task);
    }
}
