package org.bmsource.resources;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

import org.bmsource.entity.Book;
import org.bmsource.service.BookService;

@Stateless
@Path("books")
public class BookResource {

	@EJB
	private BookService bookService;

	@GET
	@Path("/{id}")
	public Response getBooks(@PathParam("id") Long id) {
		Book book = bookService.getById(id);
		return Response.ok("book " + book.toString()).build();
	}
}
