package com.tomek.domek.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component

// Not @repository beacuse we will use static arraylist not database
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private static int userCounter = 3;

	Logger log = LoggerFactory.getLogger(this.getClass());

	static {
		users.add(new User(1, "tomek", new Date()));

		users.add(new User(2, "marlena", new Date()));

		users.add(new User(3, "iga", new Date()));
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

	public void deleteUserByID(int id) {
		users.remove(id);

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

			}else
		 {

		log.info("sending null NAME");
		return null;
		}}
		return null;
	}

	public void deleteUserByName(String name) {

		users.remove(findOneByName(name));
	}

}
