package it.kafkatest.consumerproducer.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.DefaultKafkaHeaderMapper;
import org.springframework.kafka.support.KafkaHeaderMapper;

@Configuration
public class KafkaConfig {

	@Bean("customKafkaHeaderMapper")
	public KafkaHeaderMapper kafkaHeaderMapper() {
		DefaultKafkaHeaderMapper mapper = new DefaultKafkaHeaderMapper();
		Map<String, Boolean> customHeaders = new HashMap<>();
		customHeaders.put("active", Boolean.TRUE);
		mapper.setRawMappedHeaders(customHeaders);
		return mapper;
	}

	/**
	 * E' possibile usare questo metodo in sostituzione del precedente per settare automaticamente gli apici negli header dei messaggi
	 * Se si sceglie di utilizzare questo metodo RICORDARSI DI TOGLIERE IL SETTING MANUALE DEGLI APICI NEI MESSAGGI
	@Bean
	public DefaultKafkaHeaderMapper defaultKafkaHeaderMapper() {
		DefaultKafkaHeaderMapper defaultKafkaHeaderMapper = new DefaultKafkaHeaderMapper();
		defaultKafkaHeaderMapper.setEncodeStrings(true);
		return defaultKafkaHeaderMapper;
	}
	 */
}
