package com.sandun.schedule.config;

import com.sandun.schedule.entity.Schedule;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    //holds Bootstrap server URL
    @Value("localhost:9092")
    private String bootstrapServers;


    @Bean
    public Map<String, Object> producerConfig(){
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    //Producer Factory which responsible for creating producer instances
    //todo: Change String to Object Which we want to send

    @Bean
    public ProducerFactory<String, Schedule> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    //todo: Change String to Object Which we want to send

    @Bean
    public KafkaTemplate<String, Schedule> KafkaTemplate(
            ProducerFactory<String, Schedule> producerFactory
    ) {
        return new KafkaTemplate<>(producerFactory);
    }

}
