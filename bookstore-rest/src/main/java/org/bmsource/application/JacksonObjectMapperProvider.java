package org.bmsource.application;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;

@Provider
@Produces(MediaType.APPLICATION_JSON)
public class JacksonObjectMapperProvider implements ContextResolver<ObjectMapper> {

	private ObjectMapper mapper;

	public JacksonObjectMapperProvider() {
		mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
	}

	@Override
	public ObjectMapper getContext(Class<?> objectType) {
		return mapper;
	}

}