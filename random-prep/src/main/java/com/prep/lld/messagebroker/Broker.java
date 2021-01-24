package com.prep.lld.messagebroker;

import java.util.*;

public class Broker {

    private final Map<String, Topic> topicMap;
    private static Broker BROKER;

    public static Broker getInstance() {
        if (BROKER == null) {
            synchronized (Broker.class) {
                if (BROKER == null) {
                    BROKER = new Broker();
                }
            }
        }
        return BROKER;
    }

    private Broker() {
        this.topicMap = new HashMap<>();
    }

    public Topic getTopic(String name) {
        return topicMap.get(name);
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
}
