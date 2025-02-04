package ssafy.ssafyGit.book.exception;

public class ISBNNotFoundException extends Exception {

	public ISBNNotFoundException() {
		this("해당 isbn이 존재하지 않습니다.");
	}

	public ISBNNotFoundException(String message) {
		super(message);
	}
}
