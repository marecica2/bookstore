package org.bmsource.service.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class EventProducerEjb {

	private static final Logger logger = LoggerFactory.getLogger(EventProducerEjb.class);

	@Resource(lookup = "java:/myJmsTest/MyConnectionFactory")
	ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/myJmsTest/MyTopic")
	Destination topicDestination;

	public void createEvent(String payment) {

		try (Connection connection = connectionFactory.createConnection();
				Session session = connection.createSession(true, Session.SESSION_TRANSACTED);
				MessageProducer producer = session.createProducer(topicDestination)) {
			TextMessage message = session.createTextMessage(payment);
			producer.send(message);
			session.commit();
		} catch (JMSException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}
}
