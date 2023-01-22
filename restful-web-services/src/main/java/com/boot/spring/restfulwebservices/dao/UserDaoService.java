package com.boot.spring.restfulwebservices.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.boot.spring.restfulwebservices.beans.User;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static Integer userCount = 0;

	static {
		users.add(new User(++userCount, "Adam", LocalDateTime.now().minusYears(30)));
		users.add(new User(++userCount, "Eve", LocalDateTime.now().minusYears(20)));
		users.add(new User(++userCount, "Jimmy", LocalDateTime.now().minusYears(20)));
	}

	public List<User> findAll() {
		return users;
	}

	public User findById(Integer id) {
		if (id == null || id == 0) {
			return null;
		}
		Optional<User> userOpt = users.stream().filter(u -> u.getId() == id).findFirst();
		if (userOpt.isPresent()) {
			return userOpt.get();
		}
		return null;
	}

	public User save(User user) {
		user.setId(++userCount);
		users.add(user);
		return user;
	}
}
