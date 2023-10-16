package it.kafkatest.consumerproducer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.kafkatest.consumerproducer.services.ConsumerService;

@RestController
@RequestMapping("/producer")
public class MyController {

	@Autowired
	private ConsumerService service;
	
	
	@GetMapping(value = "send")
	public ResponseEntity<Void> sendMessage(){
		
		service.sendMyOutputEvent();
		return ResponseEntity.ok().build();
	}
	
}
