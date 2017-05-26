package edu.asu.diging.contestantA.config;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.apache.kafka.common.serialization.StringSerializer;


@Configuration
public class KafkaProducerConfig {
	private KafkaTemplate<Integer, String> template;
	
	@PostConstruct
	private void init() {
	    Map<String, Object> senderProps = senderProps();
	    ProducerFactory<Integer, String> pf =
	              new DefaultKafkaProducerFactory<Integer, String>(senderProps);
	    template = new KafkaTemplate<>(pf);
	}	
	
	private Map<String, Object> senderProps() {
	    Map<String, Object> props = new HashMap<>();
	    props.put(ProducerConfig.CLIENT_ID_CONFIG, "test.app.producer");
	    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
	    props.put(ProducerConfig.RETRIES_CONFIG, 0);
	    props.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
	    props.put(ProducerConfig.LINGER_MS_CONFIG, 1);
	    props.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
	    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
	    return props;
	}
}
