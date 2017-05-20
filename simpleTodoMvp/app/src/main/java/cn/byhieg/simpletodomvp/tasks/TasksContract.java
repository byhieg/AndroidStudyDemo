package cn.byhieg.simpletodomvp.tasks;

import android.support.annotation.NonNull;

import java.util.List;

import cn.byhieg.simpletodomvp.BasePresenter;
import cn.byhieg.simpletodomvp.BaseView;
import cn.byhieg.simpletodomvp.data.Task;

/**
 * Created by byhieg on 17/5/15.
 * Contact with byhieg@gmail.com
 */

public interface TasksContract {

    interface View extends BaseView<Presenter> {

        void setLoadingIndicator(boolean active);

        void showTasks(List<Task> tasks);

        void showAddTask();

        void showTaskDetailsUi(String taskId);

        void showTaskMarkedComplete();

        void showTaskMarkedActive();

        void showCompletedTasksCleared();

        void showLoadingTasksError();

        void showNoTasks();

        void showActiveFilterLabel();

        void showCompletedFilterLabel();

        void showAllFilterLabel();

        void showNoActiveTasks();

        void showNoCompletedTasks();

        void showSuccessfullySavedMessage();

        boolean isActive();

        void showFilteringPopUpMenu();
    }

    interface Presenter extends BasePresenter {

        void result(int requestCode,int resultCode);

        void loadTasks(boolean forceUpdate);

        void addNewTasks();

        void openTaskDetails(@NonNull Task requestTask);

        void completeTask(@NonNull Task completedTask);

        void activateTask(@NonNull Task activeTask);

        void clearCompletedTasks();

        void setFiltering(TasksFilterType requestType);

        TasksFilterType getFiltering();
    }
}
