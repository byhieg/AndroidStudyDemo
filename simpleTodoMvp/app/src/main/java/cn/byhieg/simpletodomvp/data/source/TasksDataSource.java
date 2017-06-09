package cn.byhieg.simpletodomvp.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import cn.byhieg.simpletodomvp.data.Task;

/**
 * Created by byhieg on 17/5/15.
 * Contact with byhieg@gmail.com
 */

public interface TasksDataSource {

    interface LoadTasksCallback{

        void onTasksLoaded(List<Task> taskList);

        void onDataNotAvailable();
    }

    interface GetTaskCallBack{

        void onTaskLoaded(Task task);

        void onDataNotAvailable();
    }


    void getTasks(@NonNull LoadTasksCallback callback);

    void getTask(@NonNull String id, @NonNull GetTaskCallBack callBack);

    void saveTask(@NonNull Task task);

    void completeTask(@NonNull Task task);

    void completeTask(@NonNull String taskId);

    void activeTask(@NonNull Task task);

    void activeTask(@NonNull String taskId);

    void clearCompletedTasks();

    void refreshTasks();

    void deleteAllTasks();

    void deleteTask(@NonNull String taskId);

}
