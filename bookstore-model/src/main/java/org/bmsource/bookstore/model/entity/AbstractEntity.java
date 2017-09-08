package org.bmsource.bookstore.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	private static final long serialVersionUID = -3211695713650358871L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_gen")
	long id;

	@Version
	@Column(name = "version", columnDefinition = "integer DEFAULT 0", nullable = false)
	private Long version;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate = new Date();

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastModifiedDate = new Date();

	public Date getCreatedDate() {
		return createdDate;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	@PreUpdate
	private void setLastModifiedDate() {
		this.lastModifiedDate = new Date();
	}

	public long getId() {
		return id;
	}

	public Long getVersion() {
		return version;
	}

}
