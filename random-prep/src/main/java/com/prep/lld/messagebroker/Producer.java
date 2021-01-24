package com.prep.lld.messagebroker;

import java.util.*;

public class Producer implements Runnable {

    private final String name;
    private volatile Map<String, Topic> topicMap;
    private int producedCount = 0;

    public Producer(String name) {
        this.name = name;
        this.topicMap = new HashMap<>();
    }

    public void addTopic(Topic topic) {
        this.topicMap.put(topic.getName(), topic);
    }

    public List<String> getAllTopicNames() {
        return new ArrayList<>(topicMap.keySet());
    }

    public List<Topic> getAllTopics() {
        return new ArrayList<>(topicMap.values());
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (producedCount < 20) {
            for (Map.Entry<String, Topic> entry : topicMap.entrySet()) {
                Message message = new Message(name, UUID.randomUUID().toString());
                entry.getValue().addMessage(message);
                producedCount++;
                System.out.println("message : " + message);
                ThreadUtils.sleep(5000);
            }
        }
    }
}
