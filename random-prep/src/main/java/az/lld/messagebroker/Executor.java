package az.lld.messagebroker;

import com.ds.utils.NumberUtils;

import java.util.stream.IntStream;

public class Executor {

    public static void main(String[] args) {
        int topicAndProducerCount = 2;
        int subscriberCount = 5;
        Broker broker = Broker.getInstance();
        String topicPrefix = "topic-";
        String subscriberPrefix = "subscriber-";
        String producerPrefix = "producer-";
        IntStream.rangeClosed(1, topicAndProducerCount).forEach(i -> {
            Topic topic = new Topic(topicPrefix + i);
            broker.addTopic(topic);
            Thread thread = new Thread(topic);
            thread.start();
        });
        IntStream.rangeClosed(1, subscriberCount).forEach(i -> {
            String name = subscriberPrefix + i;
            Topic randomTopic = broker.getTopic(topicPrefix + NumberUtils.getRandomInt(1, topicAndProducerCount));
            Subscriber subscriber = new Subscriber(name);
            System.out.println("subscriber : " + name + " subscribed to : " + randomTopic.getName());
            subscriber.addTopic(randomTopic);
            randomTopic.addSubscriber(subscriber);
        });
        IntStream.rangeClosed(1, topicAndProducerCount).forEach(i -> {
            Producer producer = new Producer(producerPrefix + i);
            producer.addTopic(broker.getTopic(topicPrefix + i));
            Thread producerThread = new Thread(producer);
            producerThread.start();
        });
    }

}
