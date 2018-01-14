package app.consult.witczak.jakub.com.concultapp.panel.student.task.fragment.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import app.consult.witczak.jakub.com.concultapp.R;
import app.consult.witczak.jakub.com.concultapp.model.Task;
import app.consult.witczak.jakub.com.concultapp.panel.student.task.adapter.EvaluatedTaskListAdapter;

public class EvaluatedTaskListFragment extends Fragment implements EvaluatedTaskListContract.View {

    private EvaluatedTaskListPresenter presenter;
    private RecyclerView recyclerView;
    private EvaluatedTaskListAdapter adapter;
    private EvaluatedTaskListFragmentInteractionWithActivityListener listener;

    public static EvaluatedTaskListFragment newInstance() {
        return new EvaluatedTaskListFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_evaluated_task_list, container, false);
        presenter = new EvaluatedTaskListPresenter(this);
        initComponents(view);
        setRecyclerView();
        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.loadTasks();
    }

    private void initComponents(View view) {
        recyclerView = view.findViewById(R.id.evaluated_task_list);
    }

    @Override
    public void refreshView(List<Task> tasks) {
        adapter.updateTaskList(tasks);
    }

    private void setRecyclerView() {
        adapter = new EvaluatedTaskListAdapter();
        adapter.setOnTutorsListItemClickListener(task -> {
            listener.showTaskDetailsActivity(task);
        });
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof EvaluatedTaskListFragmentInteractionWithActivityListener) {
            listener = (EvaluatedTaskListFragmentInteractionWithActivityListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement EvaluatedTaskListFragmentInteractionWithActivityListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    public interface EvaluatedTaskListFragmentInteractionWithActivityListener {
        void showTaskDetailsActivity(Task task);
    }
}
