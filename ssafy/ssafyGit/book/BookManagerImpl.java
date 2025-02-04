package ssafy.ssafyGit.book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        Book b = searchByIsbn(book.getIsbn());
        if (b == null) {
            books.add(book);
        }
    }

    @Override
    public void remove(String isbn) {
        Book b = searchByIsbn(isbn);
        if (b != null) {
            books.remove(b);
        }
    }

    @Override
    public Book[] getList() {
        return books.toArray(new Book[books.size()]);
    }

    @Override
    public Book searchByIsbn(String isbn) {
        for (int i = 0; i < books.size(); i++) {
            Book b = books.get(i);
            if (b.getIsbn().equals(isbn))
                return b;
        }
        return null;
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
        Collections.sort(books);
        return books.toArray(new Book[books.size()]);
    }

    @Override
    public Book[] sortDescByIsbn() {
        Collections.sort(books, new Comparator<Book>() {

            @Override
            public int compare(Book o1, Book o2) {

                return -o1.compareTo(o2);
            }

        });
        return books.toArray(new Book[books.size()]);
    }

}
