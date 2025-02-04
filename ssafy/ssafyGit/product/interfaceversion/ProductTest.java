package ssafy.ssafyGit.product.interfaceversion;

public class ProductTest {
    public static void main(String[] args) {
        IProductManager pm = ProductManagerImpl.getInstance();
        IProductManager pm2 = ProductManagerImpl.getInstance();

        Product p1 = new Product("1", "제품1", 10000, 10, "A", "~~~");
        Product p2 = new Product("2", "제품2", 30000, 5, "B", "~~~~~");

        Refrigerator refrigerator1 = new Refrigerator("11", "냉장고1", 10, 100, "sam", "sung", "냉장고", 10, false, 100);
        Refrigerator refrigerator2 = new Refrigerator("121", "냉장고21", 10, 100, "sam", "sung", "냉냉장고", 10, false, 100);
        Refrigerator refrigerator3 = new Refrigerator("113", "냉장고31", 10, 100, "sam", "sung", "냉동고", 10, true, 100);
        Refrigerator refrigerator4 = new Refrigerator("1123", "냉장고313", 10, 100, "sam", "sung", "냉동동고", 10, true, 100);

        Review r1 = new Review(1, "1", "w1", "~~~");
        Review r2 = new Review(2, "1", "w2", "~~~~~");
        Review r3 = new Review(3, "2", "w1", "~");

        pm.addProduct(p1);
        pm.addProduct(p2);
        pm.addReview(r1);
        pm.addReview(r2);
        pm.addReview(r3);
        pm.addProduct(refrigerator1);
        pm.addProduct(refrigerator2);
        pm.addProduct(refrigerator3);
        pm.addProduct(refrigerator4);
        pm2.addProduct(p1);

        // System.out.println(pm2.getTotalPrice());
        // 해당 클래스의 객체가 하나로 유지된다...

        System.out.println("--------------냉장고 목록-----------------------------");
        Refrigerator[] p = pm.getRefrigerators();
        for (Refrigerator refrigerator : p) {
            System.out.println(refrigerator);
        }

        System.out.println("------------------냉동고 있는 목록-------------------------");
        p = pm.getRefrigeratorsFreeze(true);
        for (Refrigerator refrigerator : p) {
            System.out.println(refrigerator);
        }

        System.out.println("-------------------이름 검색------------------------");
        Product[] pp = pm.searchByName("3");
        for (Product product : pp) {
            System.out.println(product);
        }
        System.out.println(pm.getTotalPrice());
    }
}
