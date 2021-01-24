package com.prep.task.executor;

public class Driver {

    public static void main(String[] args) {

        TestAbstractWorkflow workflow = new TestAbstractWorkflow();
        System.out.println(WorkflowExecutor.execute(workflow, "Request string"));
        WorkflowExecutor.shutdown();

    }


}
