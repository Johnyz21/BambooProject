package project.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Transaction {
	
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
	
	@ManyToOne
	private Account from;

	@OneToOne
	private Account to;
	
	private BigDecimal bambeuros;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Account getFrom() {
		return from;
	}

	public void setFrom(Account from) {
		this.from = from;
	}

	public Account getTo() {
		return to;
	}

	public void setTo(Account to) {
		this.to = to;
	}

	public BigDecimal getBambeuros() {
		return bambeuros;
	}

	public void setBambeuros(BigDecimal bambeuros) {
		this.bambeuros = bambeuros;
	}
	
	
}
