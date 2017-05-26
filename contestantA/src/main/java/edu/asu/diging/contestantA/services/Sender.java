package edu.asu.diging.contestantA.services;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


public class Sender {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;
	final static Logger logger = Logger.getLogger(Sender.class);
	
	public void send(String topic, String message) {
	    // the KafkaTemplate provides asynchronous send methods returning a Future
	    ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, message);

	    // register a callback with the listener to receive the result of the send asynchronously
	    future.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {

	      @Override
	      public void onSuccess(SendResult<String, String> result) {
	    	//logger.info("sent message = " +message+ " with offset = "+result.getRecordMetadata().offset() );
	      }

	      @Override
	      public void onFailure(Throwable ex) {
	    	logger.error("unable to send message = "+ message + ex);
	      }
	    });

	    // or, to block the sending thread to await the result, invoke the future's get() method
	  }
}
