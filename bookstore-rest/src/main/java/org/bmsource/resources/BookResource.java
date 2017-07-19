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

import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.service.BookstoreService;

@Stateless
@Path("books")
@Produces(MediaType.APPLICATION_JSON)
@Transactional
public class BookResource {

	@EJB
	private BookstoreService bookService;

	@GET
	public Response getBooks() {
		Collection<Book> books = bookService.getBooks();
		return Response.ok(books).build();
	}

	@GET
	@Path("/{id}")
	public Response getBook(@PathParam("id") Long id) {
		return Response.ok(bookService.getBook(id)).build();
	}

	@POST
	public Response createBook(Book book, @Context UriInfo uriInfo) {
		book = bookService.createBook(book);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Long.toString(book.getId()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateBook(Book book) {
		bookService.updateBook(book);
		return Response.ok(book).build();
	}

}
