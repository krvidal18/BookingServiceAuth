package pw.io.booker.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Service;

import pw.io.booker.exception.ErrorFoundException;
import pw.io.booker.repo.TokenRepository;

@Aspect
@Service
public class AuthenticationAspect {
	
	TokenRepository tokenService;
	

	public AuthenticationAspect(TokenRepository tokenService) {
		super();
		this.tokenService = tokenService;
	}

	@Around("execution(* pw.io.booker.controller..*(..)) && args(token)")
	public Object validation(ProceedingJoinPoint jointPoint, String token) throws Throwable{
		if (tokenService.findByToken(token) == null) {
			throw new ErrorFoundException("Token Not Found Error");
		}
		else if (token == null) {
			throw new ErrorFoundException("Token not yet existing");
		}
		return jointPoint.proceed();
	}
}
