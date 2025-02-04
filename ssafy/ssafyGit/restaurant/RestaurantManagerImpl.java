package ssafy.ssafyGit.restaurant;

import java.util.Arrays;

public class RestaurantManagerImpl implements IRestaurantManager {
    private static final int MAX_RESTAURANT_SIZE = 100;
    private Restaurant[] restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
    private int resturentSize;

    // 유일한 인스턴스 생성 (이른 초기화, Eager Initialization)
    private static final IRestaurantManager instance = new RestaurantManagerImpl();

    // private 생성자 (외부에서 객체 생성 방지)
    private RestaurantManagerImpl() {
    }

    // 유일한 인스턴스를 반환하는 메서드
    public static IRestaurantManager getInstance() {
        return instance;
    }

    // -------------------구현
    @Override
    public boolean addRestaurant(Restaurant restaurant) {
        if (resturentSize < MAX_RESTAURANT_SIZE) {
            restaurants[resturentSize++] = restaurant;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeRestaurant(int resId) {
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i].getResid() == resId) {
                restaurants[i] = restaurants[--resturentSize];
                return true;
            }
        }
        return false;
    }

    @Override
    public Restaurant searchByresId(int resId) {
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i].getResid() == resId) {
                return restaurants[i];
            }
        }
        return null;
    }

    @Override
    public Restaurant[] getRestaurantList() {
        return Arrays.copyOf(restaurants, resturentSize);
    }

    @Override
    public KoreanRestaurant[] getKoreanRestaurantList() {
        KoreanRestaurant[] krtmp = new KoreanRestaurant[MAX_RESTAURANT_SIZE];
        int tmpcnt = 0;
        for (int i = 0; i < resturentSize; i++) {
            if (restaurants[i] instanceof KoreanRestaurant) {
                krtmp[tmpcnt++] = (KoreanRestaurant) restaurants[i];
            }
        }
        return Arrays.copyOf(krtmp, tmpcnt);
    }

    @Override
    public Restaurant[] getNonKoreanRestaurants() {
        Restaurant[] tmp = new Restaurant[MAX_RESTAURANT_SIZE];
        int tmpcnt = 0;
        for (int i = 0; i < resturentSize; i++) {
            if (!(restaurants[i] instanceof KoreanRestaurant)) {
                tmp[tmpcnt++] = restaurants[i];
            }
        }
        return Arrays.copyOf(tmp, tmpcnt);
    }

}
