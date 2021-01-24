package com.prep.lld.messagebroker;

import java.util.*;

public class Topic implements Runnable {

    private final String name;
    private volatile Set<Subscriber> subscribers;
    private volatile Queue<Message> queue;

    public Topic(String name) {
        this.name = name;
        this.queue = new ArrayDeque<>();
        this.subscribers = new HashSet<>();
    }

    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public Set<Subscriber> getSubscribers() {
        return subscribers;
    }

    public String getName() {
        return name;
    }

    public void addMessage(Message message) {
        System.out.println("topic : " + name + " received : " + message);
        queue.add(message);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Topic topic = (Topic) o;
        return Objects.equals(name, topic.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void run() {
        while (true) {
            while (!queue.isEmpty()) {
                Message message = queue.poll();
                for (Subscriber subscriber : subscribers) {
                    System.out.println("sending : " + message + " to : " + subscriber.getName());
                    subscriber.receiveMessage(message);
                }
            }
        }
    }

}
