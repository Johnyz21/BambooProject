package project.repository;

import org.springframework.data.repository.CrudRepository;

import project.entity.Account;

public interface AccountRepository  extends CrudRepository<Account, Integer>{

}
