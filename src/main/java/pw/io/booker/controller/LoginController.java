package pw.io.booker.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pw.io.booker.model.Authentication;
import pw.io.booker.model.Customer;
import pw.io.booker.repo.CustomerRepository;

public class LoginController {
	CustomerRepository customerRepository;
	Authentication authenticationRepository;
	
	public LoginController(CustomerRepository customerRepository, Authentication authenticationRepository) {
		super();
		this.customerRepository = customerRepository;
		this.authenticationRepository = authenticationRepository;
	}

	@PostMapping("/login")
	public Customer loginCustomer(@RequestBody Customer customer) {
		if (customerRepository.findById(customer.getCustomerId()).isPresent()) {
			authenticationRepository
		}
		else {
			throw new RuntimeException("Error logging in: No existing records present.");
		}
	}

}
