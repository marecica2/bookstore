// package org.bmsource.application;
//
// import javax.ws.rs.core.Response;
// import javax.ws.rs.core.Response.Status;
// import javax.ws.rs.ext.ExceptionMapper;
// import javax.ws.rs.ext.Provider;
//
// import org.hibernate.LazyInitializationException;
//
// @Provider
// public class BookstoreExceptionMapper implements
// ExceptionMapper<LazyInitializationException> {
//
// @Override
// public Response toResponse(LazyInitializationException exception) {
// return
// Response.status(Status.BAD_REQUEST).entity(exception.getMessage()).build();
// }
//
// }
