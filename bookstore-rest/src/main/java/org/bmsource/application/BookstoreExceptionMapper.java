package org.bmsource.application;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.bmsource.service.BookstoreException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provider
public class BookstoreExceptionMapper implements ExceptionMapper<BookstoreException> {

	Logger logger = LoggerFactory.getLogger(BookstoreExceptionMapper.class);

	@Override
	public Response toResponse(BookstoreException exception) {
		final Writer sw = new StringWriter();
		final PrintWriter pw = new PrintWriter(sw, true);
		exception.printStackTrace(pw);

		Map<String, String> error = new LinkedHashMap<>();
		error.put("message", exception.getMessage());
		error.put("stacktrace", sw.toString());

		logger.error(exception.getMessage(), exception);
		return Response.status(Status.BAD_REQUEST).entity(error).build();
	}

}
