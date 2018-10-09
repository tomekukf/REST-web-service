package com.tomek.domek.user;

import java.net.URI;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResources {

	Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private UserDaoService userDao;

	
	
	@GetMapping(path="/users")
	public List<User> retriveAllUsers(){
		return userDao.findALl();
		
	}
	
	
	
	
	@GetMapping(path="/users/{id}")
	public User getUSerByID(@PathVariable int id ) {
		
		
		 User user = userDao.findOne(id); 
		 if(user == null)
			 throw new UserNotFoundException("id = " +id);
		 
		  
		 return user;
	}
	
	@PostMapping(path="/users")
	public ResponseEntity<Object> saveUser(@RequestBody User user ) {
		
		
		User savedUser = userDao.saveUser(user);
		
		URI location = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(savedUser
			.getId())
			.toUri();
		
		
		log.info(String.format("User with details %s was saved ! ", user));
//		List<User> list = userDao.findALl();
//		for(User users: list) {
//			System.out.println(users);
//		}
		log.info(String.format("Under location : %s", location));
		
		
		return 	ResponseEntity.created(location).build();
		
		
	}
	
	//delete by id 
	@DeleteMapping(path="/users/{id}")
	public void deleteUser ( @PathVariable int id) {
		userDao.deleteUserByID(id);
		
		User user = userDao.findOne(id);
		if(user==null) {
			log.info("deletedById");
			
		}else {
			log.info("sth went wrong, we could not delted usere by Id");
		}
		
	}
	//delete by name 
	
	
	@DeleteMapping(path="/users/name/{name}")
	public void deleteUser ( @PathVariable String name) {
		userDao.deleteUserByName(name);
		
		User user = userDao.findOneByName(name);
		if(user==null) {
			log.info("deletedByName");
			
		}else {
			log.info("sth went wrong, we could not delted user by Name");
		}
		
	}
//	@PostMapping
//	public void saveUSer(User user)
	
	
	
	
}
