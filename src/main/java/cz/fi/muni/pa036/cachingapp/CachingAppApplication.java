package cz.fi.muni.pa036.cachingapp;

import cz.fi.muni.pa036.cachingapp.entity.Branch;
import cz.fi.muni.pa036.cachingapp.entity.User;
import cz.fi.muni.pa036.cachingapp.service.UserService;
import cz.fi.muni.pa036.cachingapp.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class CachingAppApplication {

	private static final Logger logger = LoggerFactory.getLogger(CachingAppApplication.class);

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(CachingAppApplication.class, args);
		UserService userService = applicationContext.getBean(UserServiceImpl.class);
		List<User> results = userService.listAllUsers();
		logger.info("Users size: " + results.size());
		User firstResult = results.get(0);
		logger.info("The first record: " + firstResult.toString() + " with name: " + firstResult.getName() + " " + firstResult.getSurname());
		Branch usersBranch = firstResult.getBranch();
		logger.info("His branch:" + usersBranch.toString() + " with name: " + usersBranch.getName() + " in the city: " + usersBranch.getCity());
	}
}
