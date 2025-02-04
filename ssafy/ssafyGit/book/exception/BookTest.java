package ssafy.ssafyGit.book.exception;

public class BookTest {

	public static void main(String[] args) {
		IBookManager manager = BookManagerImpl.getInstance();
		manager.add(new Book("35355", "분석설계", "소나무", "jaen.kr", 30000, "SW 모델링", 20));
		manager.add(new Magazine("45678", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "1월 알고리즘", 30, 2021, 1));
		manager.add(new Magazine("45679", "월간 알고리즘", "홍길동", "jaen.kr", 10000, "2월 알고리즘", 15, 2021, 2));
		manager.add(new Book("21424", "Java Pro", "김하나", "jaen.kr", 15000, "Java 기본 문법", 20));
		manager.add(new Book("21425", "Java Pro2", "김하나", "jaen.kr", 25000, "Java 응용", 5));

		System.out.println("----------------All Books");
		for (Book b : manager.getList()) {
			System.out.println(b);
		}
		System.out.println("----------------Sort All Books");
		Book[] bs = manager.sortByIsbn();
		for (Book b : bs) {
			System.out.println(b);
		}
		System.out.println("----------------Sort All DESC Books");
		bs = manager.sortDescByIsbn();
		for (Book b : bs) {
			System.out.println(b);
		}

		try {
			manager.sell("21425", 30);
		} catch (QuantityException e) {
			System.out.println("수량부족으로 판매실패!!");
		} catch (ISBNNotFoundException e) {
			System.out.println("없는 책을 팔려고 함!!");
		} catch (Exception e) {
			System.out.println("쉬고하게");
		}
	}

}
