package it.kafkatest.consumerproducer.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@SuppressWarnings("deprecation")
public interface MyOutputStream {

	@Output("myOutputTopic")
	MessageChannel myOutputChannel();
}
