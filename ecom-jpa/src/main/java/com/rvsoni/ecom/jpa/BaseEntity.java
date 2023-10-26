package com.rvsoni.ecom.jpa;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

@MappedSuperclass
public class BaseEntity implements Serializable{

	private static final long serialVersionUID = -815678284414565432L;
	
	@Id
	@Type(type = "org.hibernate.type.PostgresUUIDType")
	UUID id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "Created")
	Date created;
	
	@PrePersist
	public void prePersist() {
		if (this.created == null) {
			created = new Date();
		}
		additionalPrePersist();
	}
	
	public UUID getId() {
		return id;
	}

	public Date getCreated() {
		return created;
	}

	public void additionalPrePersist() {
		
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseEntity other = (BaseEntity) obj;
		return Objects.equals(id, other.id);
	}
}
