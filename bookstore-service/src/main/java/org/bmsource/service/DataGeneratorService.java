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
import org.bmsource.bookstore.model.entity.Content;
import org.bmsource.bookstore.model.entity.Order;
import org.bmsource.bookstore.model.entity.OrderProduct;
import org.bmsource.bookstore.model.entity.Role;
import org.bmsource.bookstore.model.entity.User;
import org.bmsource.dao.AuthorDAO;
import org.bmsource.dao.BookDAO;
import org.bmsource.dao.OrderDAO;
import org.bmsource.dao.UserDAO;

@Singleton
@Startup
public class DataGeneratorService {

	@EJB
	private BookDAO bookDAO;

	@EJB
	private AuthorDAO authorDAO;

	@EJB
	private UserDAO customerDAO;

	@EJB
	private OrderDAO orderDAO;

	@PostConstruct
	public void init() {
		generateData();
	}

	private List<User> generateUsers(int size, List<Role> roles) {
		List<User> ret = new ArrayList<>();

		String firstNames[] = { "Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "James", "John", "Robert",
				"Michael", "William" };
		String lastNames[] = { "Smith", "Jones", "Taylor", "Williams", "Brown", "Davies", "Evans", "Wilson", "Thomas",
				"Roberts" };

		Random randomGenerator = new Random();
		for (int i = 0; i < size; i++) {
			User customer = new User();
			customer.setFirstName(firstNames[randomGenerator.nextInt(10)]);
			customer.setLastName(lastNames[randomGenerator.nextInt(10)]);
			customer.getSettings().put("locale", "en");
			customer.setRole(roles.get(0));
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
			book.setName(titles[randomGenerator.nextInt(titles.length)]);
			book.setDescription(titles[randomGenerator.nextInt(titles.length)]);
			book.getAuthors().add(authors.get(randomGenerator.nextInt(authors.size() - 1)));
			Content content = new Content();
			content.setContentType("text");
			content.setContent(book.getDescription().getBytes());
			book.setContent(content);
			ret.add(book);
		}
		return ret;
	}

	private List<Order> generateOrders(List<Book> books, List<User> customers) {
		List<Order> ret = new ArrayList<>();
		Random randomGenerator = new Random();
		customers.stream().forEach(user -> {
			for (int i = 0; i < randomGenerator.nextInt(5); i++) {
				Order order = new Order();
				order.setUser(user);
				user.getOrders().add(order);
				orderDAO.create(order);

				for (int j = 0; j < randomGenerator.nextInt(3) + 1; j++) {

					Book book = books.get(randomGenerator.nextInt(books.size() - 1));
					OrderProduct op = new OrderProduct();
					op.setProduct(book);
					op.setQuantity(randomGenerator.nextInt(4) + 1);
					op.setOrder(order);
					order.getOrderProducts().add(op);
					try {
						orderDAO.getEntityManager().flush();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		});
		return ret;
	}

	private void generateData() {
		List<Author> authors = generateAuthors(5);
		authors.stream().forEach(author -> authorDAO.create(author));

		List<Book> books = generateBooks(15, authors);
		books.stream().forEach(book -> bookDAO.create(book));

		List<Role> roles = generateRoles();

		List<User> users = generateUsers(10, roles);
		users.stream().forEach(customer -> customerDAO.create(customer));

		List<Order> orders = generateOrders(books, users);
		orders.stream().forEach(order -> orderDAO.create(order));
	}

	private List<Role> generateRoles() {
		Role role = new Role();
		role.setRole("basic");
		List<Role> roles = new ArrayList<>();
		roles.add(role);
		return roles;
	}
}
