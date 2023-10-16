package it.kafkatest.consumerproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import it.kafkatest.consumerproducer.stream.MyInputStream;
import it.kafkatest.consumerproducer.stream.MyOutputStream;

@SpringBootApplication
@EnableBinding(
	    value = {
	  	  MyInputStream.class,
	  	  MyOutputStream.class
	    })
@EnableTransactionManagement
public class ConsumerProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerProducerApplication.class, args);
	}

}
