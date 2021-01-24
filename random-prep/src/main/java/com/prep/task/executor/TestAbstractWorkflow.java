package com.prep.task.executor;

import java.util.concurrent.ConcurrentHashMap;

public class TestAbstractWorkflow extends AbstractWorkflow<String> {

    @Override
    public void populateTaskSet() {
        addTask(new TestTask1(), 1);
        addTask(new TestTask2(), 2);
        addTask(new TestTask1(), 1);
        addTask(new TestTask2(), 2);
    }

    @Override
    public String aggregateResponse(ConcurrentHashMap<AbstractTask, Object> map) {
        StringBuilder sb = new StringBuilder();
        map.forEach((key, value) -> sb.append(key.getName()).append(" : ").append(value).append("\n"));
        return sb.toString();
    }

}
