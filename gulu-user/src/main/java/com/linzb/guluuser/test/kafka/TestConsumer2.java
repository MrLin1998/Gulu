package com.linzb.guluuser.test.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.listener.AcknowledgingMessageListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;


@Component
public class TestConsumer2 implements AcknowledgingMessageListener<String,String> {


    @Override
    public void onMessage(ConsumerRecord<String, String> consumerRecord, Acknowledgment acknowledgment) {
        String value = consumerRecord.value();
        System.out.println("消费内容>>>>"+value);
        acknowledgment.acknowledge();
    }
}
