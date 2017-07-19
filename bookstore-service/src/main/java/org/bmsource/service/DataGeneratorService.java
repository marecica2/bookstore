package org.bmsource.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import org.bmsource.bookstore.model.entity.Author;
import org.bmsource.bookstore.model.entity.Book;
import org.bmsource.bookstore.model.entity.Customer;
import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.dao.AuthorDAO;
import org.bmsource.dao.BookDAO;
import org.bmsource.dao.CustomerDAO;
import org.bmsource.dao.OrderDAO;

@Singleton
@Startup
public class DataGeneratorService {

	@EJB
	private BookDAO bookDAO;

	@EJB
	private AuthorDAO authorDAO;

	@EJB
	private CustomerDAO customerDAO;

	@EJB
	private OrderDAO orderDAO;

	@PostConstruct
	public void init() {
		// generateData();
	}

	private List<Customer> generateCustomers(int size) {
		List<Customer> ret = new ArrayList<>();

		String firstNames[] = { "Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "James", "John", "Robert",
				"Michael", "William" };
		String lastNames[] = { "Smith", "Jones", "Taylor", "Williams", "Brown", "Davies", "Evans", "Wilson", "Thomas",
				"Roberts" };

		Random randomGenerator = new Random();
		for (int i = 0; i < size; i++) {
			Customer customer = new Customer();
			customer.setFirstName(firstNames[randomGenerator.nextInt(10)]);
			customer.setLastName(lastNames[randomGenerator.nextInt(10)]);
			ret.add(customer);
		}
		return ret;
	}

	private List<Author> generateAuthors(int size) {
		List<Author> ret = new ArrayList<>();

		String firstNames[] = { "Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "James", "John", "Robert",
				"Michael", "William" };
		String lastNames[] = { "Smith", "Jones", "Taylor", "Williams", "Brown", "Davies", "Evans", "Wilson", "Thomas",
				"Roberts" };

		Random randomGenerator = new Random();
		for (int i = 0; i < size; i++) {
			Author customer = new Author();
			customer.setFirstName(firstNames[randomGenerator.nextInt(10)]);
			customer.setLastName(lastNames[randomGenerator.nextInt(10)]);
			ret.add(customer);
		}
		return ret;
	}

	private List<Book> generateBooks(int size, List<Author> authors) {
		List<Book> ret = new ArrayList<>();

		String titles[] = { "To Kill A Mockingbird", "Their Eyes Were Watching God", "The Grapes Of Wrath",
				"For Whom The Bell Tolls", "A Confederacy Of Dunces", "As I Lay Dying", "Of Mice And Men",
				"I Capture The Castle",
				"No Country For Old Men", "How to Lose Friends and Alienate People",
				"Another Bullshit Night in Suck City" };

		Random randomGenerator = new Random();
		for (int i = 0; i < size; i++) {
			Book book = new Book();
			book.setIsbn("ISBN" + System.currentTimeMillis());
			book.setTitle(titles[randomGenerator.nextInt(titles.length)]);
			book.getAuthors().add(authors.get(randomGenerator.nextInt(authors.size() - 1)));
			ret.add(book);
		}
		return ret;
	}

	private List<Order> generateOrders(List<Book> books, List<Customer> customers) {
		List<Order> ret = new ArrayList<>();
		Random randomGenerator = new Random();
		for (int i = 0; i < randomGenerator.nextInt(10); i++) {
			Order order = new Order();
			for (int j = 0; j < randomGenerator.nextInt(4); j++) {
				order.getBooks().add(books.get(randomGenerator.nextInt(books.size() - 1)));
			}
		}
		return ret;
	}

	private void generateData() {
		List<Author> authors = generateAuthors(5);
		authors.stream().forEach(author -> authorDAO.create(author));

		List<Book> books = generateBooks(15, authors);
		books.stream().forEach(book -> bookDAO.create(book));

		List<Customer> customers = generateCustomers(10);
		customers.stream().forEach(book -> customerDAO.create(book));

		List<Order> orders = generateOrders(books, customers);
		orders.stream().forEach(order -> orderDAO.create(order));
	}
}
