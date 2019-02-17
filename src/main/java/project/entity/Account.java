package project.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
	@OneToOne(mappedBy="account")
	private User user;
	
	@OneToMany(mappedBy="from", cascade = CascadeType.PERSIST)
	private Set<Transaction> outgoingTransactions;
	
	private BigDecimal bambeuros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public Set<Transaction> getOutgoingTransactions() {
		return outgoingTransactions;
	}

	public void setOutgoingTransactions(Set<Transaction> outGoingTransactions) {
		this.outgoingTransactions = outGoingTransactions;
	}

	public BigDecimal getBambeuros() {
		return bambeuros;
	}

	public void setBambeuros(BigDecimal bambeuros) {
		this.bambeuros = bambeuros;
	}
	
	
}
