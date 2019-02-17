package project.repository;

import org.springframework.data.repository.CrudRepository;

import project.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);
}