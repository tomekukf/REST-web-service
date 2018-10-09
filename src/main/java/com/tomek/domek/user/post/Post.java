package com.tomek.domek.user.post;

import java.util.Date;

public class Post {

	private int id;
	private String text;
	private Date creationTime;
	public int getId() {
		return id;
	}
	public void setId(int id) {
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
	public Post(int id, String text, Date creationTime) {
		super();
		this.id = id;
		this.text = text;
		this.creationTime = creationTime;
	}
	public Post() {
		super();
	}
	
	
	
	
}
