package ssafy.ssafyGit.restaurant;

import java.util.Arrays;

public class RestaurantManager {
    private static final int MAX_RESTAURANT_SIZE = 100;
    private static final int MAX_REVIEW_SIZE = 100;

    private Restaurant[] restaurants = new Restaurant[MAX_RESTAURANT_SIZE];
    private Review[] reviews = new Review[MAX_REVIEW_SIZE];

    private int resturentSize;
    private int reviewSize;

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

    public boolean addRestaurant(Restaurant restaurant) {
        if (resturentSize < MAX_RESTAURANT_SIZE) {
            restaurants[resturentSize++] = restaurant;
            return true;
        }
        return false;
    }

    public boolean addReview(Review review) {
        if (reviewSize < MAX_REVIEW_SIZE) {
            reviews[reviewSize++] = review;
            return true;
        }
        return false;
    }

    public boolean updateRestaurant(Restaurant restaurant) {

        for (int i = 0; i < restaurants.length; i++) {
            if (restaurant.getResid() == restaurants[i].getResid()) {
                restaurants[i] = restaurant;
                return true;
            }
        }
        return false;
    }

    public boolean removeRestaurant(int resId) {
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i].getResid() == resId) {
                restaurants[i] = restaurants[--resturentSize];
                return true;
            }
        }
        return false;
    }

    public boolean removeReview(int reviewId) {
        for (int i = 0; i < reviews.length; i++) {
            if (reviews[i].getReviewId() == reviewId) {
                reviews[i] = reviews[--reviewSize];
                return true;
            }
        }
        return false;
    }

    public Restaurant searchByresId(int resId) {
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i].getResid() == resId) {
                return restaurants[i];
            }
        }
        return null;
    }

    public Restaurant[] getRestaurantList() {
        return Arrays.copyOf(restaurants, resturentSize);
    }

    public Review[] getRestaurantReviewList() {
        return Arrays.copyOf(reviews, reviewSize);
    }

    public Restaurant getRestaurant(int resId) {
        for (int i = 0; i < restaurants.length; i++) {
            if (restaurants[i].getResid() == resId) {
                return restaurants[i];
            }
        }
        return null;
    }

}