package it.kafkatest.consumerproducer.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MyInputEvent extends MyEvent {

	private static final String EVENT_TYPE = "headers['My-EventType']=='MyInputEvent'";
	//private static final String EVENT_VERSION = "headers['X-SA-EventVersion']=='v0'";
	//public static final String CONDITION = EVENT_TYPE + " and " + EVENT_VERSION;
	
	public static final String CONDITION = "headers['My-EventType']=='MyInputEvent'";

	
	private String subject;
	private String message;
	
}
