package com.prep.task.executor;

import com.prep.multithreading.ThreadUtils;

public class TestTask2 extends AbstractTask<String, String> {

    private static final long SLEEP_TIME = 100;

    @Override
    public String getName() {
        return "task2";
    }

    @Override
    public long getTimeOfExecutionInMillis() {
        return SLEEP_TIME;
    }

    @Override
    public boolean isRunnable(String request) {
        return true;
    }

    @Override
    public String process(String request) {
        ThreadUtils.sleep(SLEEP_TIME);
        return "got request : " + request + " in " + getName();
    }

}
