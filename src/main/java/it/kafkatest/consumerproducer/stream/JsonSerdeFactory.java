package it.kafkatest.consumerproducer.stream;

import org.apache.kafka.common.serialization.Serde;

@FunctionalInterface
public interface JsonSerdeFactory {

	<T> Serde<T> buildFrom(Class<T> target);
}
