package org.bmsource.bookstore.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@SequenceGenerator(name = "default_gen", sequenceName = "seq_content", allocationSize = 1)
@Table(name = "CONTENT")
public class Content extends AbstractEntity {

	private static final long serialVersionUID = 5889388362380911466L;

	@Column(name = "CONTENT_TYPE")
	private String contentType;

	@Lob
	@Column(name = "CONTENT", length = 10000)
	private byte[] content;

	@OneToOne(targetEntity = Product.class, mappedBy = "content")
	private Product product;

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

}
