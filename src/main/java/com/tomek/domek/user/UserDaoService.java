package com.tomek.domek.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.tomek.domek.user.post.Post;

@Component

// Not @repository beacuse we will use static arraylist not database
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static List<Post> user1Posts = new ArrayList<>();

	private static List<Post> user2Posts = new ArrayList<>();

	private static List<Post> user3Posts = new ArrayList<>();

	private static int userCounter = 3;
	private static int postCounter = 2;

	Logger log = LoggerFactory.getLogger(this.getClass());

	static {
		user1Posts.add(new Post(1, "hi im tomek how are you", new Date()));
		user1Posts.add(new Post(2, "my second post", new Date()));

		user2Posts.add(new Post(1, "hi im marlena how are you ?", new Date()));
		user2Posts.add(new Post(2, "my second post", new Date()));

		user3Posts.add(new Post(1, "hi im iga how are you u", new Date()));
		user3Posts.add(new Post(2, "my second post", new Date()));

		users.add(new User(1, "tomek", new Date(), user1Posts));

		users.add(new User(2, "marlena", new Date(), user2Posts));

		users.add(new User(3, "iga", new Date(), user3Posts));
	}

	// find all method

	public List<User> findALl() {
		return users;
	}

	// save User

	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++userCounter);
		}
		if (user.getBirthDate() == null) {
			user.setBirthDate(new Date());
		}
		users.add(user);
		return user;
	}

	public User deleteUserByID(int id) {
		
		Iterator<User> iterator = users.iterator();
		while (iterator.hasNext()) {
			User user = iterator.next();
			if(user.getId() == id) {
				iterator.remove();
				return user;
			}
					
		}
		return null;

	}

	public User findOne(int id) {

		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		log.info("sending null ID");

		return null;
	}

	public User findOneByName(String name) {

		for (User user : users) {
			if (user.getName() == name) {
				log.info("sending user ");
				return user;

			} else {

				log.info("sending null NAME");
				return null;
			}
		}
		return null;
	}

	public void deleteUserByName(String name) {

		users.remove(findOneByName(name));
	}

	public List<Post> finaAllPostWithUserID(int id) {

		if (findOne(id) == null) {
			throw new UserNotFoundException("id = " + id);
		}
		User user = this.findOne(id);

		List<Post> postList = user.getPostList();

		return postList;

	}

	public Post savePostForUser(Post post, int id) {
		if (findOne(id) == null) {
			throw new UserNotFoundException("id = " + id);
		}
		User user = this.findOne(id);
		List<Post> list = user.getPostList();

		
			post.setId(++postCounter);
		
		if (post.getCreationTime() == null) {
			post.setCreationTime(new Date());
		}

		list.add(post);
		return post;
	}
}
