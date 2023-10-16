package it.kafkatest.consumerproducer.consumers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import it.kafkatest.consumerproducer.events.MyInputEvent;
import it.kafkatest.consumerproducer.services.ConsumerService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class MyInputTopicConsumer {
	
	@Autowired
	private ConsumerService service;

	@StreamListener(target = "myInputTopic", condition = MyInputEvent.CONDITION)
	public void consumeMyInputTopic(@NonNull @Payload MyInputEvent event, @Headers Map<String, Object> headers) {
		
		log.info("Ricevuto messaggio su topic KT.myInputTopic. Chiamo il service");
		service.consume(event);
		log.info("Operazione completata");
	}
}
