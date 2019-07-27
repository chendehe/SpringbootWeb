package com.chendehe.kafka;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * @author CDH
 * @since 2019/7/27 16:42
 */
@Service
public class KafkaService {

  private KafkaTemplate<String, Object> kafkaTemplate;

  public KafkaService(KafkaTemplate<String, Object> kafkaTemplate) {
    this.kafkaTemplate = kafkaTemplate;
  }

  public String produce(Message msg) {

    ProducerRecord<String, Object> data = new ProducerRecord<>(msg.getTopic(), msg.getMsg());

    System.out.println(msg);
    kafkaTemplate.send(data)
        .addCallback(new ListenableFutureCallback<SendResult<String, Object>>() {
          @Override
          public void onSuccess(SendResult<String, Object> result) {
            System.out.println("成功" + result);
          }

          @Override
          public void onFailure(Throwable ex) {
            System.out.println("失败" + ex);
          }
        });
    return "";
  }

  @KafkaListener(topics = {"test"})
  public String consume(String message) {
    System.out.println("app_log--消费消息:" + message);
    return "---";
  }

}
