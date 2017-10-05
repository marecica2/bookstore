package org.bmsource.resources;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.ws.rs.DefaultValue;
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

import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.interceptor.RestResource;
import org.bmsource.service.BookstoreException;
import org.bmsource.service.BookstoreService;
import org.bmsource.service.OrderService;
import org.modelmapper.ModelMapper;

@RestResource
@Stateless
@Path("orders")
@Produces(MediaType.APPLICATION_JSON)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class OrderResource {

	private final ModelMapper dtoMapper = new ModelMapper();

	@EJB(lookup = "java:global/bookstore-ear/bookstore-service/BookstoreServiceEjb!org.bmsource.service.BookstoreService")
	private BookstoreService bss;

	@EJB(lookup = "java:global/bookstore-ear/bookstore-service/OrderServiceEjb!org.bmsource.service.OrderService")
	private OrderService os;

	@GET
	public Response getOrders() {
		Collection<Order> orders = os.testLazyEager();
		return Response.ok(orders).build();
	}

	@GET
	@Path("/{id}")
	public Response getOrder(@PathParam("id") Long id) {
		Order order = bss.getOrder(id);
		return Response.ok(order).build();
	}

	@POST
	public Response createOrder(Order order, @Context UriInfo uriInfo) {

		order = bss.createOrder(order);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(order.getId()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateOrder(Order order) {
		bss.updateOrder(order);
		return Response.ok(order).build();
	}

	@GET
	@Path("/{id}/placeOrder/{rollback}")
	public Response placeOrder(@PathParam("id") Long id,
			@PathParam("rollback") @DefaultValue("false") boolean rollback) throws BookstoreException {
		Order order = bss.getOrder(id);
		order = bss.submitOrder(order, rollback);
		return Response.ok(order).build();
	}

}
