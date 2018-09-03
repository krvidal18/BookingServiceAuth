package pw.io.booker.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Token {
	@GeneratedValue
	@Id
	private int tokenId;
	private String token;
	@OneToOne
	@JoinColumn(name = "customerId")
	private Customer customer;

	public Customer getCustomer() {
		return customer;
	}
	
	public int getTokenId() {
		return tokenId;
	}

	public void setTokenId(int tokenId) {
		this.tokenId = tokenId;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
