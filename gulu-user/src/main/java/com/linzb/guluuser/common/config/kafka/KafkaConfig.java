package com.linzb.guluuser.common.config.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.support.Acknowledgment;

@Configuration
public class KafkaConfig implements InitializingBean, AcknowledgingMessageListener<String,Object> {

    @Autowired
    ConsumerFactory consumerFactory;

//    @Bean
//    KafkaMessageListenerContainer kafkaMessageListenerContainer(){
//        ContainerProperties containerProperties = new ContainerProperties("test");
//        containerProperties.setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
//        containerProperties.setMessageListener(this);
//        containerProperties.setMissingTopicsFatal(false);
//        return new KafkaMessageListenerContainer(consumerFactory,containerProperties);
//    }


    @Override
    public void afterPropertiesSet() throws Exception {
        ContainerProperties containerProperties = new ContainerProperties("test");
        containerProperties.setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        containerProperties.setMessageListener(this);
        KafkaMessageListenerContainer kafkaMessageListenerContainer = new KafkaMessageListenerContainer(consumerFactory, containerProperties);
        kafkaMessageListenerContainer.start();
    }



    @Override
    public void onMessage(ConsumerRecord<String, Object> consumerRecord, Acknowledgment acknowledgment) {
        Object value = consumerRecord.value();
        System.out.println("====开始消费"+value.toString());
        acknowledgment.acknowledge();
        System.out.println("====结束消费");

    }
}
