package project.entity;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity 
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private Account account;
    
    private String username;
    
    private String password;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encryptedPw = encoder.encode(password);
		this.password = encryptedPw;
	}
	
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void addTransaction(Transaction t) {
		this.account.getOutgoingTransactions().add(t);
	}
	
}
