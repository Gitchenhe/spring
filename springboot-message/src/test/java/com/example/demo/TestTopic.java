
package com.example.demo;

import kafka.admin.AdminUtilities;
import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.server.ConfigType;
import kafka.utils.ZkUtils;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerRebalanceListener;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.KafkaFuture;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.security.JaasUtils;
import org.apache.zookeeper.ZKUtil;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * Created by chenhe on 2018/3/3.
 */
public class TestTopic {
    private Logger LOGGER = LoggerFactory.getLogger(TestTopic.class);

    private final String TOPIC_NAME = "test_topic_1";//主题名称
    private final String BOOTSTRAP_SERVERS = "106.15.199.29:9092";//主题地址
    private final String ZOOKEEPER_SERVERS = "106.15.199.29:2181";

    @Test
    public void testCreateTopic() {
        LOGGER.info("方式1创建主题");
        ZkUtils zkUtils = ZkUtils.apply(ZOOKEEPER_SERVERS, 3000, 3000, JaasUtils.isZkSecurityEnabled());

        AdminUtils.createTopic(zkUtils, TOPIC_NAME, 1, 1, new Properties(), RackAwareMode.Enforced$.MODULE$);

        zkUtils.close();
    }

    @Test
    public void testCreateTopic2() {
        LOGGER.info("方式2创建主题");
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        //对kafka服务器进行配置
        AdminClient adminClient = AdminClient.create(props);
        ArrayList<NewTopic> topics = new ArrayList<>();
        //主题名称是TOPIC_NAME,分区数为1,复制因子为1
        NewTopic newTopic = new NewTopic(TOPIC_NAME, 1, (short) 1);
        topics.add(newTopic);

        CreateTopicsResult result = adminClient.createTopics(topics);
        try {
            LOGGER.info("准备创建主题");
            KafkaFuture future = result.all();
            future.get();
            LOGGER.info("主题创建完成");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testDeleteTopic() {
        LOGGER.info("删除主题");
        ZkUtils zkUtils = ZkUtils.apply(ZOOKEEPER_SERVERS, 3000, 3000, JaasUtils.isZkSecurityEnabled());
        AdminUtils.deleteTopic(zkUtils, TOPIC_NAME);
        zkUtils.close();
    }

    @Test
    public void queryTopic(){
        ZkUtils zkUtils = ZkUtils.apply(ZOOKEEPER_SERVERS, 3000, 3000, JaasUtils.isZkSecurityEnabled());
        Properties pros = AdminUtils.fetchEntityConfig(zkUtils, ConfigType.Topic(),TOPIC_NAME);
        Iterator it = pros.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry entry = (Map.Entry) it.next();
            LOGGER.info("topic key ={},value={}",entry.getKey(),entry.getValue());
        }
        zkUtils.close();
    }

    /**
     * 消费者消费消息
     */
    @Test
    public void testProducer() {
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer<>(props);
        for (int i = 0; i < 100; i++) {
            producer.send(new ProducerRecord<>(TOPIC_NAME, "key_" + i, "消息:"+i), (recordMetadata, e) -> callback(recordMetadata, e));
        }

        producer.close();
    }

    /**
     * 生产者消息回调
     *
     * @param recordMetadata
     * @param e
     */
    private void callback(RecordMetadata recordMetadata, Exception e) {
        LOGGER.error("发送失败",e);
    }

    @Test
    public void testConsumer(){
        Properties props = new Properties();
        props.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,BOOTSTRAP_SERVERS);
        props.put("group.id",TOPIC_NAME);
        props.put("enable.auto.commit",true);
        props.put("auto.commit.interval.ms","1000");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String,String> consumer = new KafkaConsumer<>(props);
        consumer.subscribe(Arrays.asList(TOPIC_NAME), new ConsumerRebalanceListener() {
            @Override
            public void onPartitionsRevoked(Collection<TopicPartition> collection) {

            }

            @Override
            public void onPartitionsAssigned(Collection<TopicPartition> collection) {
                consumer.seekToBeginning(collection);
            }
        });

        while (true){
            ConsumerRecords<String, String> records = consumer.poll(100);
            for (ConsumerRecord<String,String> record : records){
                LOGGER.info("offset={},key={},value={}",record.offset(),record.key(),record.value());
            }
        }
    }

}
