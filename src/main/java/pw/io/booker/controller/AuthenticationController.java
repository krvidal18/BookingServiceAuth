package pw.io.booker.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import pw.io.booker.model.Customer;
import pw.io.booker.model.Token;
import pw.io.booker.repo.CustomerRepository;
import pw.io.booker.service.TokenService;

@RestController
@Transactional
public class AuthenticationController {
	CustomerRepository customerRepository;
	TokenService tokenService;
	
	public AuthenticationController(CustomerRepository customerRepository, TokenService tokenService) {
		super();
		this.customerRepository = customerRepository;
		this.tokenService = tokenService;
	}

	@PostMapping("/login")
	public String loginCustomer(@RequestBody Customer customer) {
		String token = null;
		if (customerRepository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword()) != null) {
			Customer custom = customerRepository.findByUsernameAndPassword(customer.getUsername(), customer.getPassword());
			token = tokenService.createToken(custom);
			Token newToken = new Token();
			newToken.setCustomer(custom);
			newToken.setToken(token);
			tokenService.saveToken(newToken);
		}
		else {
			throw new RuntimeException("Error logging in: No existing records present.");
		}
		return token;
	}
	
	@DeleteMapping("/logout")
	public void logoutCustomer(@RequestHeader String token) {
		tokenService.deleteToken(token);
	}

}
