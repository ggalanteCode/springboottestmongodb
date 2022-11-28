package com.soprasteria.springboottestmongodb.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.soprasteria.springboottestmongodb.constants.KafkaConstants;
import com.soprasteria.springboottestmongodb.model.Studente;

@Configuration
@EnableKafka
public class StudenteProducerAndConsumerConfig {
	
	@Bean
	public ProducerFactory<String, Object> producerFactory() {
		Map<String, Object> configMap = new HashMap<>();
		configMap.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_SERVER_CONFIG);
		configMap.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configMap.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "com.soprasteria.springboottestmongodb.model");
		return new DefaultKafkaProducerFactory<String, Object>(configMap);
	}
	
	@Bean
	public KafkaTemplate<String, Object> kafkaTemplate() {
		return new KafkaTemplate<>(producerFactory());
	}
	
	@Bean
	public ConsumerFactory<String, Studente> consumerFactory() {
		Map<String, Object> configMap = new HashMap<>();
		configMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, KafkaConstants.KAFKA_SERVER_CONFIG);
		configMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		configMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		configMap.put(ConsumerConfig.GROUP_ID_CONFIG, KafkaConstants.GROUP_ID_JSON);
		configMap.put(JsonDeserializer.TRUSTED_PACKAGES, "com.soprasteria.springboottestmongodb.model");
		configMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
		configMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, false);
		return new DefaultKafkaConsumerFactory<>(configMap);
	}
	
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Studente> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Studente> factory = new ConcurrentKafkaListenerContainerFactory<String, Studente>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}

}
