package com.chendehe.kafka;

import java.util.List;
import java.util.Map;
import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

/**
 * 可选.
 */
public class MyPartitioner implements Partitioner {

  @Override
  public void configure(Map<String, ?> configs) {
    // TODO Auto-generated method stub

  }

  @Override
  public int partition(String topic, Object key, byte[] keyBytes,
                       Object value, byte[] valueBytes, Cluster cluster) {
    int partition = 0;
    List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);
    int numPartitions = partitions.size();
    String stringKey = (String) key;
    int offset = stringKey.lastIndexOf('.');
    if (offset > 0) {
      partition = Integer.parseInt(stringKey.substring(offset + 1)) % numPartitions;
    }

    return partition;
  }

  @Override
  public void close() {
    // TODO Auto-generated method stub

  }

  // 启动kafka .\bin\windows\kafka-server-start.bat .\config\server.properties
  // 查询TOPIC kafka-topics.bat --list --zookeeper localhost:2181
  // 生产 kafka-console-producer.bat --broker-list localhost:9092 --topic chendehe1
  // 消费 kafka-console-consumer.bat --zookeeper localhost:2181 --topic chendehe1 --from-beginning
}