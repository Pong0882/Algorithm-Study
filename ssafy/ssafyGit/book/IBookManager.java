package ssafy.ssafygit.book;

public interface IBookManager {

    void add(Book book);

    void remove(String isbn);

    Book[] getList();

    Book searchByIsbn(String isbn);

    Book[] searchByTitle(String title);

    Book[] getBooks();

    Magazine[] getMagazines();

    int getTotolPrice();

    double getPriceAvg();

    Book[] sortByIsbn();

    Book[] sortDescByIsbn();

}
