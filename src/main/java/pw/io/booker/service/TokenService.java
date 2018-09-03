package pw.io.booker.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pw.io.booker.model.Customer;
import pw.io.booker.model.Token;
import pw.io.booker.repo.TokenRepository;

@Service
@Transactional
public class TokenService {
	private TokenRepository tokenRepository;
	private TokenCreatorService tokenCreatorService;


	public TokenService(TokenRepository tokenRepository,
			TokenCreatorService tokenCreatorService) {
		super();
		this.tokenRepository = tokenRepository;
		this.tokenCreatorService = tokenCreatorService;
	}

	public String createToken(Customer customer) {
		return tokenCreatorService.encode(customer);
	}
	
	public Token saveToken(Token token) {
		return tokenRepository.save(token);
	}
	
	public void deleteToken(String token) {
		tokenRepository.deleteByToken(token);
	}

	public Token findByToken(String token) {
		return tokenRepository.findByToken(token);
	}
	
}
