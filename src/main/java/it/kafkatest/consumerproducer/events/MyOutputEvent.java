package it.kafkatest.consumerproducer.events;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
public class MyOutputEvent extends MyEvent {
	
	private static final String EVENT_TYPE = "headers['My-EventType']=='MyOuputEvent'";
	//private static final String EVENT_VERSION = "headers['X-SA-EventVersion']=='v0'";
	
	public static final String CONDITION = EVENT_TYPE;
	//public static final String CONDITION = EVENT_TYPE + " and " + EVENT_VERSION;

	private String object;
	private String message;
	
	@Override
	public String getEventKey() {
		return "MyOuputEventKey";
	}
}
