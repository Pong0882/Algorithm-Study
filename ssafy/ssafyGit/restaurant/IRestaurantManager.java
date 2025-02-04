package ssafy.ssafyGit.restaurant;

public interface IRestaurantManager {
    public boolean addRestaurant(Restaurant restaurant);

    public boolean removeRestaurant(int resId);

    // public boolean updateRestaurant(Restaurant restaurant);

    public Restaurant searchByresId(int resId);

    public Restaurant[] getRestaurantList();

    public KoreanRestaurant[] getKoreanRestaurantList();

    public Restaurant[] getNonKoreanRestaurants();
}
