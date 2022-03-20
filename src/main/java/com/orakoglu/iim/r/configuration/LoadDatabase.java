package com.orakoglu.iim.r.configuration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import com.orakoglu.iim.r.entity.User;
import com.orakoglu.iim.r.repository.UserRepository;

@Controller
public class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Bean
	public CommandLineRunner initDatabase(UserRepository userRepository) {
		return args -> {
			User user1 = new User();
			user1.setUsername("xdat1");
			user1.setPassword("1234");
			log.info("Preloading "
					+ userRepository.save(user1));
			User user2 = new User();
			user2.setUsername("blut");
			user2.setPassword("1234");
			log.info("Preloading "
					+ userRepository.save(user2));
		};
	}
}
