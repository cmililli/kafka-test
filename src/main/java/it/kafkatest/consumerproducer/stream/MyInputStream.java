package it.kafkatest.consumerproducer.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

@SuppressWarnings("deprecation")
public interface MyInputStream {

	
	@Input("myInputTopic")
	SubscribableChannel myInputChannel();
}
