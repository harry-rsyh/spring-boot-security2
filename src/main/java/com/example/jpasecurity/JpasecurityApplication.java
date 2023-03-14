package com.example.jpasecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.jpasecurity.model.Post;
import com.example.jpasecurity.model.User;
import com.example.jpasecurity.repository.PostRepository;
import com.example.jpasecurity.repository.UserRepository;

@SpringBootApplication
public class JpasecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpasecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(PostRepository posts, UserRepository users, PasswordEncoder passwordEncoder){
		return args -> {
			users.save(new User("user", passwordEncoder.encode("password"), "ROLE_USER"));
			users.save(new User("admin", passwordEncoder.encode("password"), "ROLE_USER,ROLE_ADMIN"));
			posts.save(new Post("Hello, World","hello-world", "Welcome to my blog!", "Harry R"));
		};
	}

}
