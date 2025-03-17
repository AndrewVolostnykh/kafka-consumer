package andrew.volostnykh.kafkaconsumer.service;

import andrew.volostnykh.kafkaconsumer.core.config.RecognitionTopicsConfig;
import andrew.volostnykh.kafkaconsumer.model.RecognitionResult;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecognitionListenerService {

    private final KafkaService kafkaService;
    private final RecognitionTopicsConfig recognitionTopicsConfig;

    @PostConstruct
    public void init() {
        kafkaService.subscribe(recognitionTopicsConfig.getInbound(), this::handleRecognitionResult);
    }

    public void handleRecognitionResult(RecognitionResult recognitionResult) {
        // Logic for processing and saving to DB here
    }
}
