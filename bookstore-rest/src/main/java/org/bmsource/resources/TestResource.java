package org.bmsource.resources;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.bmsource.interceptor.RestResource;
import org.bmsource.service.Async;

@RestResource
@Stateless
@Path("test")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class TestResource {

	@EJB(lookup = "java:global/bookstore-ear/bookstore-service/AsyncEjb!org.bmsource.service.Async")
	private Async async;

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
