package it.kafkatest.consumerproducer.events;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.util.MimeTypeUtils;

import com.fasterxml.jackson.annotation.JsonIgnore;

public abstract class MyEvent {

	private static final String EVENT_TYPE = "My-EventType";

	@JsonIgnore
	public String getEventType() {
		return this.getClass().getSimpleName();
	}

	@JsonIgnore
	public String getEventKey() {
		return null;
	}

	public Message<MyEvent> toJsonMessage() {
		final String messageKey = getEventKey();
		final MessageBuilder<MyEvent> builder = MessageBuilder.withPayload(this)
															  .setHeader(EVENT_TYPE, getEventType())
															  .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.APPLICATION_JSON);
		if(messageKey != null) {
			builder.setHeader("partitionKey", messageKey);
		}
		return builder.build();
	}

}
