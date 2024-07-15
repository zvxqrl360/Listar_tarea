package com.utp.app.taskmanager.services;

import com.utp.app.taskmanager.models.Task;
import java.util.ArrayList;
import java.util.List;

public class TaskService {

    private List<Task> tasks = new ArrayList<>();
    private static long nextId = 1;
    private Object id;

    public List<Task> getAllTasks() {
        return tasks;
    }

    public Task getTaskById(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                return task;
            }
        }
        return null;
    }

    public void createTask(Task task) {
        task.setId(nextId++);
        tasks.add(task);
    }

    public Task updateTask(Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            if (task.getId().equals(id)) {
                updatedTask.setId((Long) id);
                tasks.set(i, updatedTask);
                return updatedTask;
            }
        }
        return null;
    }

    public boolean deleteTask(Long id) {
        for (Task task : tasks) {
            if (task.getId().equals(id)) {
                tasks.remove(task);
                return true;
            }
        }
        return false;
    }
}
