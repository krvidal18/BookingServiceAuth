package pw.io.booker.service;

import org.springframework.transaction.annotation.Transactional;

import pw.io.booker.model.Customer;
import pw.io.booker.repo.AuthenticationRepository;

public class AuthenticationService {
	private AuthenticationRepository authenticationRepository;
	private TokenCreatorService tokenCreatorService;


	public AuthenticationService(AuthenticationRepository authenticationRepository,
			TokenCreatorService tokenCreatorService) {
		super();
		this.authenticationRepository = authenticationRepository;
		this.tokenCreatorService = tokenCreatorService;
	}



	@Transactional
	public String createToken(Customer customer) {
		String token = tokenCreatorService.encode(customer);
		authenticationRepository.save();
	}
	
}
