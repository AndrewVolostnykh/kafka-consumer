package andrew.volostnykh.kafkaconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.stereotype.Service;

import java.util.function.Consumer;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaService {

    private final ConsumerFactory consumerFactory;

    public <T> void subscribe(String topic, Consumer<T> processor) {
        log.debug("Subscribing to topic {}", topic);
        this.<T>registerConsumer(topic, message -> {
            T payload = message.value();
            log.debug("Received new message for topic {}: {}", topic, payload);
            processor.accept(payload);
        });
    }

    private <T> void registerConsumer(String topic, MessageListener<String, T> messageListener) {
        ContainerProperties containerProperties = new ContainerProperties(topic);
        containerProperties.setMessageListener(messageListener);
        ConcurrentMessageListenerContainer<String, T> listenerContainer = new ConcurrentMessageListenerContainer<String, T>(consumerFactory, containerProperties);
        listenerContainer.start();
    }
}
