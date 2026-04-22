package com.gtwndtl.crudapp;

import com.gtwndtl.crudapp.entity.User;
import com.gtwndtl.crudapp.repository.UserDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudappApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserDAO dao) {
		return runner -> {
			saveData(dao);
			getAllUsers(dao);
			getUserById(dao);
			updateUser(dao);
			deleteData(dao);
		};
	}

	public void saveData(UserDAO dao) {
		User obj1 = new User("user1", "สมชาย", "สายสมร");
		dao.save(obj1);
		System.out.println("Insert Complete");
	}

	public void deleteData(UserDAO dao) {
		int id = 2;
		dao.delete(id);
		System.out.println("Delete Complete");
	}

	public void getUserById(UserDAO dao) {
		int id = 3;
		User user = dao.getById(id);
		System.out.println("Get Complete");
		System.out.println(user);
	}

	public void getAllUsers(UserDAO dao) {
		List<User> users = dao.getAll();
		for (User user : users) {
			System.out.println(user);
		}
	}

	public void updateUser(UserDAO dao) {
		int id = 4;
		User user = dao.getById(id);
		if (user != null) {
			user.setUsername("Boy1");
			user.setFname("บอย");
			user.setLname("ประกรณ์");
			dao.update(user);
			System.out.println("Update Complete");
		}
	}
}