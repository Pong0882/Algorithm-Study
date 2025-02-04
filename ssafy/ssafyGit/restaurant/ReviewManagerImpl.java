package ssafy.ssafyGit.restaurant;

import java.util.Arrays;

public class ReviewManagerImpl implements IReviewManager {
    private static final int MAX_REVIEW_SIZE = 100;
    private Review[] reviews = new Review[MAX_REVIEW_SIZE];
    private int reviewSize;

    // 싱글톤 패턴 구현
    private static final IReviewManager instance = new ReviewManagerImpl();

    private ReviewManagerImpl() {

    }

    public static IReviewManager getInstance() {
        return instance;
    }

    @Override
    public boolean addReview(Review review) {
        if (reviewSize < MAX_REVIEW_SIZE) {
            reviews[reviewSize++] = review;
            return true;
        }
        return false;
    }

    @Override
    public boolean removeReview(int reviewId) {
        for (int i = 0; i < reviews.length; i++) {
            if (reviews[i].getReviewId() == reviewId) {
                reviews[i] = reviews[--reviewSize];
                return true;
            }
        }
        return false;
    }

    @Override
    public Review[] getReviewList() {
        return Arrays.copyOf(reviews, reviewSize);
    }

    @Override
    public Review searchByreviewId(int reviewId) {
        for (int i = 0; i < reviewSize; i++) {
            if (reviews[i].getReviewId() == reviewId) {
                return reviews[i];
            }
        }
        return null;
    }

    @Override
    public Review[] getRestaurantReview(int resId) {
        Review[] tmp = new Review[MAX_REVIEW_SIZE];
        int tmpcnt = 0;
        for (int i = 0; i < reviewSize; i++) {
            if (reviews[i].getResid() == resId) {
                tmp[tmpcnt++] = reviews[i];
            }
        }
        return Arrays.copyOf(tmp, tmpcnt);
    }

}
