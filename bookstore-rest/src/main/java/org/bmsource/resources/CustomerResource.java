package org.bmsource.resources;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import org.bmsource.bookstore.model.entity.User;
import org.bmsource.service.BookstoreService;

@Stateless
@Path("customers")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class CustomerResource {

	@EJB(lookup = "java:global/bookstore-ear-0.0.1-SNAPSHOT/bookstore-service-0.0.1-SNAPSHOT/BookstoreServiceEjb!org.bmsource.service.BookstoreService")
	private BookstoreService bss;

	@GET
	public Response getCustomers() {
		Collection<User> customers = bss.getCustomers();
		return Response.ok(customers).build();
	}

	@GET
	@Path("/{id}")
	public Response getCustomer(@PathParam("id") Long id) {
		return Response.ok(bss.getCustomer(id)).build();
	}

	@POST
	public Response createCustomer(User customer, @Context UriInfo uriInfo) {

		customer = bss.createCustomer(customer);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(customer.getId()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateCustomer(User customer) {
		bss.updateCustomer(customer);
		return Response.ok(customer).build();
	}

}
