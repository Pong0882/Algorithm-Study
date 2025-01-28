package ssafy.ssafyGit.product;

public class ProductTest {
    public static void main(String[] args) {
        Product product1 = new Product("R00001", "S냉장고", 100000, 20, "삼성", "삼성에서 출시한...");
        Product product2 = new Product("P00001", "우주폰S", 100000, 20, "삼성", "삼성에서 출시한...");

        Review review1 = new Review(1, "p0001", "yang", "good");

        System.out.println(product1);
        System.out.println(product2);
        System.out.println(review1);
    }
}
