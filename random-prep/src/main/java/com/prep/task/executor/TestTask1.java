package com.prep.task.executor;

import com.prep.multithreading.ThreadUtils;

public class TestTask1 extends AbstractTask<String, String> {

    private static final long SLEEP_TIME = 200;

    @Override
    public String getName() {
        return "task1";
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
