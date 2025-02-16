package ssafy.ssafyGit.book;

public class Book implements Comparable<Book> {

    protected String isbn;
    protected String title;
    protected String author;
    protected String publisher;
    protected int price;
    protected String desc;

    public Book(String isbn, String title, String author, String publisher, int price, String desc) {
        super();
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.price = price;
        this.desc = desc;
    }

    public Book() {
        super();
    }

    @Override
    public String toString() {
        return isbn + " | " + title + " | " + author + " | " + publisher + " | " + price + " | " + desc;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public int compareTo(Book o) {
        return this.isbn.compareTo(o.isbn); // ISBN 기준 오름차순 정렬
    }

}
