package ssafy.ssafyGit.book.exception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManagerImpl implements IBookManager {
	private static IBookManager manger = new BookManagerImpl();

	private BookManagerImpl() {
		books = new ArrayList<>();
	}

	public static IBookManager getInstance() {
		return manger;
	}

	// ---------------------
	private List<Book> books;

	@Override
	public void add(Book book) {
		try {
			searchByIsbn(book.getIsbn());
			System.out.println("이미 있는 책입니다.");
		} catch (ISBNNotFoundException e) {
			books.add(book);
			System.out.println(book.getIsbn() + "이 추가되었습니다. ");
		}

	}

	@Override
	public void remove(String isbn) {
		try {
			Book b = searchByIsbn(isbn);
			books.remove(b);
			System.out.println(isbn + " 책을 제거 했습니다.");
		} catch (ISBNNotFoundException e) {
			System.out.println(isbn + "이 이 존재하지 않습니다. ");
		}

	}

	@Override
	public Book[] getList() {
		return books.toArray(new Book[books.size()]);
	}

	@Override
	public Book searchByIsbn(String isbn) throws ISBNNotFoundException {
		for (int i = 0; i < books.size(); i++) {
			Book b = books.get(i);
			if (b.getIsbn().equals(isbn))
				return b;
		}
		throw new ISBNNotFoundException(isbn + " 해당 책이 존재하지 않습니다.");
	}

	@Override
	public Book[] searchByTitle(String title) {
		List<Book> newB = new ArrayList<>();
		for (int i = 0; i < books.size(); i++) {
			Book b = books.get(i);
			if (b.getTitle().contains(title)) {
				newB.add(b);
			}
		}
		return newB.toArray(new Book[newB.size()]);
	}

	@Override
	public Book[] getBooks() {
		List<Book> newB = new ArrayList<>();
		for (int i = 0; i < books.size(); i++) {
			Book b = books.get(i);
			if (!(b instanceof Magazine)) {
				newB.add(b);
			}
		}
		return newB.toArray(new Book[newB.size()]);
	}

	@Override
	public Magazine[] getMagazines() {
		List<Magazine> newB = new ArrayList<>();
		for (Book b : books) {
			if ((b instanceof Magazine bb)) {
				newB.add(bb);
			}
		}
		return newB.toArray(new Magazine[newB.size()]);
	}

	@Override
	public int getTotolPrice() {
		int tot = 0;
		for (Book b : books) {
			tot += b.getPrice();
		}
		return tot;
	}

	@Override
	public double getPriceAvg() {
		if (!books.isEmpty() || books.size() > 0)
			return 1.0 * getTotolPrice() / books.size();
		else
			return 0.0;
	}

	@Override
	public Book[] sortByIsbn() {
		Collections.sort(books,
				(o1, o2) -> o1.getIsbn().compareTo(o2.getIsbn()));
		return books.toArray(new Book[books.size()]);
	}

	@Override
	public Book[] sortDescByIsbn() {
		Collections.sort(books,
				(o1, o2) -> (-o1.getIsbn().compareTo(o2.getIsbn())));
		return books.toArray(new Book[books.size()]);
	}

	@Override
	public void sell(String isbn, int quantity) throws ISBNNotFoundException, QuantityException {
		Book b = searchByIsbn(isbn);
		int cur = b.getQuantity();
		if (cur < quantity) {
			throw new QuantityException("책의 수가 부족합니다.");
		}
		b.setQuantity(cur - quantity);
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {

	}

}
