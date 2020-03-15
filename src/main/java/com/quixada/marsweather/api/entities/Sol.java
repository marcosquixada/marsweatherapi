package com.quixada.marsweather.api.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name = "sol")
public class Sol implements Serializable {

	private static final long serialVersionUID = 3960436649365666213L;
	
	private Long id;
	private String mx;
	private String mn;
	private String av;
	private Date createdAt;
	private Date updatedAt;
	
	public Sol() {
	}

	@Id
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "mx", nullable = false)
	public String getMx() {
		return mx;
	}

	public void setMx(String mx) {
		this.mx = mx;
	}

	@Column(name = "mn", nullable = false)
	public String getMn() {
		return mn;
	}

	public void setMn(String mn) {
		this.mn = mn;
	}
	
	@Column(name = "av", nullable = false)
	public String getAv() {
		return av;
	}

	public void setAv(String av) {
		this.av = av;
	}

	@Column(name = "createdAt", nullable = false)
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "updatedAt", nullable = false)
	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	@PreUpdate
    public void preUpdate() {
        updatedAt = new Date();
    }
     
    @PrePersist
    public void prePersist() {
        final Date atual = new Date();
        createdAt = atual;
        updatedAt = atual;
    }

	@Override
	public String toString() {
		return "Sol [id=" + id + ", mx=" + mx + ", mn=" + mn + ", createdAt=" + createdAt
				+ ", updatedAt=" + updatedAt + "]";
	}
}
