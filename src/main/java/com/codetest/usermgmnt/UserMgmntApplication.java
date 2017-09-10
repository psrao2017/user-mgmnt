package com.codetest.usermgmnt;

import java.net.URI;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.broker.TransportConnector;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class UserMgmntApplication {

	@Value("${spring.activemq.broker-url}")
	private String brokerUrl;

	public static void main(String[] args) {
		SpringApplication.run(UserMgmntApplication.class, args);
	}

	@Bean
	public BrokerService createBrokerService() throws Exception {
		BrokerService broker = new BrokerService();
		TransportConnector connector = new TransportConnector();
		connector.setUri(new URI(brokerUrl));
		broker.addConnector(connector);
		return broker;
	}
}
