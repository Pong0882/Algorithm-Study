package ssafy.ssafyGit.book;

public class BookTest {

    public static void main(String[] args) {
        IBookManager manager = BookManagerImpl.getInstance();
        manager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법"));
        manager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용"));
        manager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링"));
        manager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 2021, 2));
        manager.add(new Magazine("45679", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "2월 알고리즘", 2022, 3));

        System.out.println("----------------------");
        for (Book b : manager.getList()) {
            System.out.println(b);
        }

        Book[] bs = manager.getListSortByIsbn();
        for (Book b : bs) {
            System.out.println(b);
        }
    }
}
