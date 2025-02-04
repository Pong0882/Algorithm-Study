package ssafy.ssafyGit.book.exception;

public class QuantityException extends Exception {

	public QuantityException() {
		this("수량이 부족합니다.");
	}

	public QuantityException(String message) {
		super(message);
	}

}
