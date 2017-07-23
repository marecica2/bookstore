package org.bmsource.bookstore.model.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("CD")
@Table(name = "PRODUCT_CD")
public class CD extends Product {

}
