package ssafy.ssafygit.book;

import java.util.Arrays;

public class BookManager {
    // 싱글톤 디자인 패턴

    private static BookManager bmanager = new BookManager(); // 1. private 로 감춘다.

    private BookManager() {
        books = new Book[MAX_SIZE]; // 널널한 상태
    }

    public static BookManager getInstance() { // 2. 볼 순 있게 해줌.
        return bmanager;
    }
//------------------------------------------singletone 싱글톤 패턴

    private static final int MAX_SIZE = 100;
    private static int size;
    private Book[] books;

    // ================================================================
    // search, add , remove, getList
    // search
    public Book searchByIsbn(String isbn) {
        for (int i = 0; i < size; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                return books[i];
            }
        }
        return null;
    }

    // ----------------------
    // add
    public void add(Book b) {
        Book book = searchByIsbn(b.getIsbn());
        if (book == null) {
            books[size++] = b;
        }
    }

    // remove 뒤부터 찾아서 찾은곳에 넣어야 좋음 왜냐면 중복되는 책이 여러개 있을 경우
    // 뒤에서 돌아오면
    public void remove(int isbn) {
        for (int i = size - 1; i >= 0; i--) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i] = books[--size];
                return;
            }
        }
    }

    // getList()
    public Book[] getList() {
        return Arrays.copyOf(books, size);
    }
}
