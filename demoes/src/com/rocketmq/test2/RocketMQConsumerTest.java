package com.rocketmq.test2;

public class RocketMQConsumerTest {
    public static void main(String[] args) {  
        
        
        String mqNameServer = "172.10.254.2:9876";  
        String mqTopics = "MQ-MSG-TOPICS-TEST";  
  
        String consumerMqGroupName = "CONSUMER-MQ-GROUP";  
        RocketMQListener mqListener = new RocketMQListener();  
        RocketMQConsumer mqConsumer = new RocketMQConsumer(mqListener, mqNameServer, consumerMqGroupName, mqTopics);  
        mqConsumer.init();  
  
  
        try {  
            Thread.sleep(1000 * 60L);  
        } catch (InterruptedException e) {  
            e.printStackTrace();  
        }  
  
    } 
}
