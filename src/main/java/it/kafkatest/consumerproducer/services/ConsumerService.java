package it.kafkatest.consumerproducer.services;

import java.time.LocalDateTime;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.kafkatest.consumerproducer.events.MyInputEvent;
import it.kafkatest.consumerproducer.events.MyOutputEvent;
import it.kafkatest.consumerproducer.stream.MyOutputStream;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ConsumerService {

	@Autowired
	private MyOutputStream outstream;
	
	public void consume(MyInputEvent event) {
		log.info("Ricevuto nuovo MyInputEvent: {}" , event.toString());
		log.info("Invio un messaggio sul topic myOutputTopic..");
		sendMyOutputEvent();
	}
	
	public void sendMyOutputEvent() {
		MyOutputEvent outEvent = new MyOutputEvent();
		outEvent.setObject("Oggetto " + UUID.randomUUID());
		outEvent.setMessage("Sono il messaggio inviato alle: " + LocalDateTime.now().toString());
		outstream.myOutputChannel().send(outEvent.toJsonMessage());
		log.info("Inviato MyOutputEvent: {}" , outEvent.toString());
	}
	
}
