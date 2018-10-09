package com.tomek.domek.user.post;

import java.util.Date;

public class Post {

	private Integer id;
	private String text;
	private Date creationTime;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getCreationTime() {
		return creationTime;
	}
	public void setCreationTime(Date creationTime) {
		this.creationTime = creationTime;
	}
	@Override
	public String toString() {
		return String.format("Post [id=%s, text=%s, creationTime=%s]", id, text, creationTime);
	}
	public Post(Integer id, String text, Date creationTime) {
		super();
		this.id = id;
		this.text = text;
		this.creationTime = creationTime;
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	 
	
}
