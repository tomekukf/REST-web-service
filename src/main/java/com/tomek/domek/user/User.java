package com.tomek.domek.user;

import java.util.Date;
import java.util.List;

import com.tomek.domek.user.post.Post;

public class User {
	
	private Integer id;
	
	private String name;
	
	private Date birthDate;
	
	private List<Post> postList;
	
	

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, birthDate=%s, postList=%s]", id, name, birthDate, postList);
	}

	public User(Integer id, String name, Date birthDate, List<Post> postList) {
		super();
		this.id = id;
		this.name = name;
		this.birthDate = birthDate;
		this.postList = postList;
	}

	public List<Post> getPostList() {
		return postList;
	}

	public void setPostList(List<Post> postList) {
		this.postList = postList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}


	public User() {
		super();
	}
	
	

	

}
