package ssafy.ssafyGit.restaurant;

public class RestaurantTest {

    public static void main(String[] args) {
        IRestaurantManager resManager = RestaurantManagerImpl.getInstance();

        RestaurantManager manager = new RestaurantManager();

        Restaurant r1 = new Restaurant(101, "을미대", "서울", "냉면", 4);
        Restaurant r2 = new Restaurant(401, "도마29", "대구", "연어초밥", 3);

        Restaurant kr1 = new KoreanRestaurant(201, "가나다", "주소", "고기", 23, "123-123", "now");
        manager.addRestaurant(kr1);
        Review re1 = new Review(1, 101, "김싸피", "냉면 맛나요");
        Review re2 = new Review(2, 401, "나싸피", "연어초밥 맛나요");

        resManager.addRestaurant(kr1);
        manager.addRestaurant(r2);
        manager.addRestaurant(r1);

        System.out.println("맛집 목록");
        for (Restaurant res : manager.getRestaurantList()) {
            System.out.println(res);
        }
        System.out.println("한국 목록");
        for (Restaurant res : manager.getKoreanRestaurantList()) {
            System.out.println(res);
        }

        manager.addReview(re2);
        manager.addReview(re1);
        System.out.println("리뷰 목록");
        for (Review re : manager.getRestaurantReviewList()) {
            System.out.println(re);
        }

        System.out.println("101번 맛집 삭제 후 맛집 목록");
        manager.removeRestaurant(101);
        for (Restaurant res : manager.getRestaurantList()) {
            System.out.println(res);
        }

    }
}