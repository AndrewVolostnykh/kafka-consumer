## Kafka consumer

[Kafka Service](./src/main/java/andrew/volostnykh/kafkaconsumer/service/KafkaService.java) 
is a service with common logic for working with topics. Methods used to subscribe to topic using
processor placeholder (Consumer<T> processor arg)

[Recognition Listener Service](./src/main/java/andrew/volostnykh/kafkaconsumer/service/RecognitionListenerService.java)
is a service for listening and processing recognition messages. Uses class [Recognition Topics Config](./src/main/java/andrew/volostnykh/kafkaconsumer/core/config/RecognitionTopicsConfig.java) to get inbound 
topic name

[Recognition Topics Config](./src/main/java/andrew/volostnykh/kafkaconsumer/core/config/RecognitionTopicsConfig.java) is a 
config class contains needed topic configurations for recognition events. All the configurations are getting from 
application.properties file

[Recognition Result](./src/main/java/andrew/volostnykh/kafkaconsumer/model/RecognitionResult.java) is a model of recognition 
inbound message