package com.prep.task.executor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class AbstractWorkflow<ResponseObject> {

    private final List<Set<AbstractTask>> taskSets;

    public AbstractWorkflow() {
        this.taskSets = new ArrayList<>();
        populateTaskSet();
    }

    public void addTask(AbstractTask task, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("invalid index");
        }
        while (taskSets.size() <= index) {
            taskSets.add(new HashSet<>());
        }
        taskSets.get(index).add(task);
    }

    public List<Set<AbstractTask>> getTaskSets() {
        return taskSets;
    }

    public abstract void populateTaskSet();

    public abstract ResponseObject aggregateResponse(ConcurrentHashMap<AbstractTask, Object> map);

}
