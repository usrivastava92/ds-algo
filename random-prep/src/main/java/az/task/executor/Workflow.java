package az.task.executor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Workflow {

    private final List<Set<AbstractTask>> taskSets;

    public Workflow() {
        this.taskSets = new ArrayList<>();
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
}
