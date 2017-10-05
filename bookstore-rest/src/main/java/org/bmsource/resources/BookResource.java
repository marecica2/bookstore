package org.bmsource.resources;

import java.util.Collection;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
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

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.interceptor.RestResource;
import org.bmsource.service.BookstoreService;

@RestResource
@Stateless
@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@TransactionManagement(TransactionManagementType.CONTAINER)
public class BookResource {

	@EJB(lookup = "java:global/bookstore-ear/bookstore-service/BookstoreServiceEjb!org.bmsource.service.BookstoreService")
	private BookstoreService bss;

	@GET
	public Response getBooks() {
		Collection<Book> books = bss.getBooks();
		return Response.ok(books).build();
	}

	@GET
	@Path("/{id}")
	public Response getBook(@PathParam("id") Long id) {
		return Response.ok(bss.getBook(id)).build();
	}

	@POST
	public Response createBook(Book book, @Context UriInfo uriInfo) {

		book = bss.createBook(book);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(book.getId()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateBook(Book book) {
		bss.updateBook(book);
		return Response.ok(book).build();
	}

}
