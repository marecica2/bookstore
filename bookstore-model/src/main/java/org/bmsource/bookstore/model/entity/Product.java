package org.bmsource.bookstore.model.entity;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "PRODUCT_TYPE", discriminatorType = DiscriminatorType.STRING)
@SequenceGenerator(name = "default_gen", sequenceName = "seq_product", allocationSize = 1)
@Table(name = "PRODUCT")
public class Product extends AbstractEntity {

	private static final long serialVersionUID = 1083476485884155098L;

	@NotNull
	@Column(name = "NAME")
	private String name;

	@NotNull
	@Column(name = "DESCRIPTION")
	private String description;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTENT_ID")
	private Content content;

	private BigDecimal price;

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Product [name=" + name + ", description=" + description + ", getId()=" + getId() + "]";
	}
}
