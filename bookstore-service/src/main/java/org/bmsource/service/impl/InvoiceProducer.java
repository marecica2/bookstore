package org.bmsource.service.impl;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.QueueConnection;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
public class InvoiceProducer {

	private static final Logger logger = LoggerFactory.getLogger(InvoiceProducer.class);

	@Resource(lookup = "java:/myJmsTest/MyConnectionFactory")
	ConnectionFactory connectionFactory;

	@Resource(lookup = "java:/myJmsTest/MyQueue")
	Destination destination;

	public void sendInvoice(String payment) {

		try (QueueConnection connection = (QueueConnection) connectionFactory.createConnection();
				QueueSession session = connection.createQueueSession(true, Session.AUTO_ACKNOWLEDGE);
				MessageProducer producer = session.createProducer(destination)) {

			TextMessage message = session.createTextMessage(payment);
			producer.send(message);
		} catch (JMSException e) {
			e.printStackTrace();
			logger.error(e.getMessage(), e);
		}
	}
}
