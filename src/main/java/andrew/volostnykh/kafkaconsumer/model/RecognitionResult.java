package andrew.volostnykh.kafkaconsumer.model;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class RecognitionResult {
    private UUID id;
    private String source;
    private LocalDateTime timestamp;
    private Long lat;
    private Long lon;
    private String type;
    private Float confidence;
}
