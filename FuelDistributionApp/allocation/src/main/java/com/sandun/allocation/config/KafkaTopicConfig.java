package com.sandun.allocation.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    //todo: make only one topic that should be listed by every service but only the related service should access the data
    @Bean
    public NewTopic mainTopic(){
        return TopicBuilder.name("mainTopic")
                .build();
    }
    @Bean
    public NewTopic secondTopic(){
        return TopicBuilder.name("secondTopic")
                .build();
    }

    @Bean
    public NewTopic thirdTopic(){
        return TopicBuilder.name("thirdTopic")
                .build();
    }
}
