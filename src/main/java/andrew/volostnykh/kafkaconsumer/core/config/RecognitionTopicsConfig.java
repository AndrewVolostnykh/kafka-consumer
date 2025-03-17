package andrew.volostnykh.kafkaconsumer.core.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ConfigurationProperties(prefix = "topics.edge-device-recognition")
public class RecognitionTopicsConfig {

    private String inbound;
}
