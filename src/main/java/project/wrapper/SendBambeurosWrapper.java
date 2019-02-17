package project.wrapper;

import java.math.BigDecimal;

import project.entity.User;

public class SendBambeurosWrapper {

	
	private Integer to;
	
	private BigDecimal amount;



	public Integer getTo() {
		return to;
	}

	public void setTo(Integer to) {
		this.to = to;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
