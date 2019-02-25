package io.github.dauphine.ecophenix.DevoirJPA.entite;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="COMMENT", schema="PUBLIC")
@NamedQuery(name="Comment.findAll", query="SELECT c FROM Comment c")
public class Comment {
	  
   private int id;
   private String description;
   private Timestamp date;

	@Id @GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name="TIMESTAMP")
	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}
	   
	   

}
