package com.linzb.guluuser.test.kafka;


import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TestConsumer {

    public static Integer s1=0;
    public static Integer s2=0;
    public static Integer s3=0;


    //@KafkaListener(topics = "test",groupId="myConsumer2")
    void doBusiness(ConsumerRecord<String, String> record, Acknowledgment ack){
        System.out.println("=======开始消费1=========");
        String value = record.value();
        Integer s = Integer.valueOf(value);
        System.out.println("消息内容=>"+s);
        try {
            Thread.sleep(s);
        }catch (Exception e){}

        ack.acknowledge();
        System.out.println("=======结束消费1=========");
    }

    //@KafkaListener(topics = "test",groupId="myConsumer2")
    void doBusiness2(ConsumerRecord<String, String> record, Acknowledgment ack){
        System.out.println("=======开始消费2=========");
        String value = record.value();
        Integer s = Integer.valueOf(value);
        System.out.println("消息内容=>"+s);
        try {
            Thread.sleep(s);
        }catch (Exception e){}

        ack.acknowledge();
        System.out.println("=======结束消费2=========");
    }

    //@KafkaListener(topics = "test",groupId="myConsumer2")
    void doBusiness2(String msg, Acknowledgment ack){
        System.out.println("=======开始消费3=========");
        Integer s = Integer.valueOf(msg);
        System.out.println("消息内容=>"+s);
        try {
            Thread.sleep(s);
        }catch (Exception e){}

        ack.acknowledge();
        System.out.println("=======结束消费3=========");
    }


    //@KafkaListener(topics = "test",groupId="myConsumer1")
    void doBusinessBth(List<ConsumerRecord<String, String>> records, Acknowledgment ack){
        for (int i=0;i<records.size();i++) {
            System.out.println("本次拉取数量【"+records.size()+"】");
            System.out.println("=======开始批量消费,坐标【"+i+"】");
            String value = records.get(i).value();
            Integer s = Integer.valueOf(value);
            System.out.println("消息内容=>"+s);
            //业务
            try {
                Thread.sleep(s);
            }catch (Exception e){}
            //业务
            System.out.println("=======结束批量消费,坐标【"+i+"】");
        }
        System.out.println("=======结束批量消费");
        ack.acknowledge();
    }

    //@KafkaListener(topics = "test",groupId="myConsumer1")
    void doBusinessBth2(List<String> records, Acknowledgment ack){
        for (int i=0;i<records.size();i++) {
            System.out.println("本次拉取数量【"+records.size()+"】");
            System.out.println("=======开始批量消费,坐标【"+i+"】");
            String value = records.get(i);
            Integer s = Integer.valueOf(value);
            System.out.println("消息内容=>"+s);
            //业务
            try {
                Thread.sleep(s);
            }catch (Exception e){}
            //业务
            System.out.println("=======结束批量消费,坐标【"+i+"】");
        }
        System.out.println("=======结束批量消费");
        ack.acknowledge();
    }



    //@KafkaListener(groupId="myConsumer2",topicPartitions ={@TopicPartition(topic = "test2",partitions = {"0","1"})} )
    void doBusiness3(ConsumerRecord<String, String> record, Acknowledgment ack){
        System.out.println("=======开始消费4=========");
        String value = record.value();
        Integer s = Integer.valueOf(value);
        System.out.println("消息内容=>"+s);
        try {
            Thread.sleep(s);
        }catch (Exception e){}

        ack.acknowledge();
        System.out.println("=======结束消费4=========");
    }

//    @KafkaListener(topics = "test2",groupId="myConsumer2"
//            ,topicPartitions ={@TopicPartition(topic = "test2",partitions = {"2","3"})}
//            )
    void doBusiness4(ConsumerRecord<String, String> record, Acknowledgment ack){
        System.out.println("=======开始消费5========="+record.partition());
        String value = record.value();
        Integer s = Integer.valueOf(value);
        System.out.println("消息内容=>"+s);
        try {
            Thread.sleep(s);
        }catch (Exception e){}

        ack.acknowledge();
        System.out.println("=======结束消费5========="+record.partition());
    }

//    @KafkaListener(topics = "test2",groupId="myConsumer2"
//            ,topicPartitions ={@TopicPartition(topic = "test2",partitions = {"2","3"})}
//            )
    void doBusiness5(ConsumerRecord<String, String> record, Acknowledgment ack){
        System.out.println("=======开始消费6========="+record.partition());
        String value = record.value();
        Integer s = Integer.valueOf(value);
        System.out.println("消息内容=>"+s);
        try {
            Thread.sleep(s);
        }catch (Exception e){}

        ack.acknowledge();
        System.out.println("=======结束消费6========="+record.partition());
    }

    //@KafkaListener(topics = "test2",groupId="myConsumer2")
    void doBusiness6(ConsumerRecord<String, String> record, Acknowledgment ack){
        System.out.println("=======开始消费6========="+record.partition());
        String value = record.value();
        Integer s = Integer.valueOf(value);
        System.out.println("消息内容=>"+s);
        try {
            Thread.sleep(s);
            s1++;
        }catch (Exception e){}

        ack.acknowledge();
        System.out.println("=======结束消费6========="+record.partition()+"第几次"+s1);
    }

    //@KafkaListener(topics = "test2",groupId="myConsumer2")
    void doBusiness7(ConsumerRecord<String, String> record, Acknowledgment ack){
        System.out.println("=======开始消费7========="+record.partition());
        String value = record.value();
        Integer s = Integer.valueOf(value);
        System.out.println("消息内容=>"+s);
        try {
            Thread.sleep(s);
            s2++;
        }catch (Exception e){}

        ack.acknowledge();
        System.out.println("=======结束消费7========="+record.partition()+"第几次"+s2);
    }
    //@KafkaListener(topics = "test2",groupId="myConsumer2")
    void doBusiness8(ConsumerRecord<String, String> record, Acknowledgment ack){
        System.out.println("=======开始消费8========="+record.partition());
        String value = record.value();
        Integer s = Integer.valueOf(value);
        System.out.println("消息内容=>"+s);
        try {
            Thread.sleep(s);
            s3++;
        }catch (Exception e){}

        ack.acknowledge();
        System.out.println("=======结束消费8========="+record.partition()+"第几次"+s3);
    }

    //@KafkaListener(topics = "tax_to_mbs_kafka",groupId="tax-to-mbs")
    void tax(ConsumerRecord<String, String> record, Acknowledgment ack){
        System.out.println("=======开始消费8========="+record.partition());
        String value = record.value();
        System.out.println("消息内容=>"+value);
        try {
            System.out.println(value);
            s3++;
        }catch (Exception e){}

        ack.acknowledge();
        System.out.println("=======结束消费8========="+record.partition()+"第几次"+s3);
    }
}
