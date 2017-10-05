package org.bmsource.resources;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bmsource.interceptor.RestResource;
import org.bmsource.service.Async;
import org.bmsource.service.Counter;

@RestResource
@Stateless
@Path("test")
@Produces(MediaType.APPLICATION_JSON)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class TestResource {

	@EJB(lookup = "java:global/bookstore-ear/bookstore-service/AsyncEjb!org.bmsource.service.Async")
	private Async async;

	@EJB(lookup = "java:global/bookstore-ear/bookstore-service/CounterEjb!org.bmsource.service.Counter")
	private Counter counter;

	@GET
	@Path("counterIncrement")
	public Response counterIncrement() {
		counter.increment();
		return Response.ok(counter.count()).build();
	}

	@GET
	@Path("doNow")
	public Response doNow() {
		async.doItNow();
		return Response.ok("doNow").build();
	}

	@GET
	@Path("doItSoon")
	public Response doItSoon() {
		async.doItSoon();
		return Response.ok("doItSoon").build();
	}

	@GET
	@Path("justDoIt")
	public Response justDoIt() {
		async.justDoIt();
		return Response.ok("justDoIt").build();
	}

}
