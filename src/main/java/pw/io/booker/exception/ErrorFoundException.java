package pw.io.booker.exception;

public class ErrorFoundException extends RuntimeException{
	private String errorMessage;

	public ErrorFoundException(String errorMessage) {
		super();
		this.errorMessage = errorMessage;
	}

	@Override
	public String getMessage() {
		return errorMessage;
	}
}
