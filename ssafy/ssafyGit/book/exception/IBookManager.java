package ssafy.ssafyGit.book.exception;

public interface IBookManager {
	void add(Book book);

	void remove(String isbn);

	Book[] getList();

	Book searchByIsbn(String isbn) throws ISBNNotFoundException;

	Book[] searchByTitle(String title);

	Book[] getBooks();

	Magazine[] getMagazines();

	int getTotolPrice();

	double getPriceAvg();

	Book[] sortByIsbn();

	Book[] sortDescByIsbn();

	void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException;

	void buy(String isbn, int quantity) throws ISBNNotFoundException;
}
