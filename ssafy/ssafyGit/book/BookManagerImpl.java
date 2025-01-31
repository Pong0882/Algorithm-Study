package ssafy.ssafyGit.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookManagerImpl implements IBookManager {

    private static IBookManager manager = new BookManagerImpl();
    private List<Book> books;

    private BookManagerImpl() {
        books = new ArrayList<>();
    }

    public static IBookManager getInstance() {
        return manager;
    }

    @Override
    public void add(Book book) {
        // TODO Auto-generated method stub  
        Book b = searchByIsbn(book.getIsbn());
        if (b != null) {
            books.remove(b);
        }
    }

    @Override
    public Book[] getBooks() {
        // TODO Auto-generated method stub
        return books.toArray(new Book[books.size()]);
    }

    @Override
    public Book[] getList() {
        // TODO Auto-generated method stub
        return books.toArray(new Book[books.size()]);
    }

    @Override
    public Magazine[] getMagazines() {
        List<Magazine> magazines = new ArrayList<>();
        for (Book book : books) {
            if (book instanceof Magazine) {
                magazines.add((Magazine) book);
            }
        }
        return magazines.toArray(new Magazine[magazines.size()]);
    }

    @Override
    public double getPriceAvg() {
        if (books.isEmpty()) {
            return 0;
        }
        double sum = 0;
        for (Book book : books) {
            sum += book.getPrice();
        }
        return sum / books.size();
    }

    @Override
    public int getTotalPrice() {
        int sum = 0;
        for (Book book : books) {
            sum += book.getPrice();
        }
        return sum;
    }

    @Override
    public void remove(String isbn) {
        books.removeIf(book -> book.getIsbn().equals(isbn));
    }

    @Override
    public Book[] searchByTitle(String title) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                result.add(book);
            }
        }
        return result.toArray(new Book[result.size()]);
    }

    @Override
    public Book searchByIsbn(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;

    }

    @Override
    public Book[] getListSortByIsbn() {
        Collections.sort(books);
        return books.toArray(new Book[books.size()]);
    }

    @Override
    public Book[] sortDescByIsbn() {
        Collections.sort(books, (o1, o2) -> (-o1.compareTo(o2)));

        return books.toArray(new Book[books.size()]);
    }
}
