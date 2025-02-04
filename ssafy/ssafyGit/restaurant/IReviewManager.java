package ssafy.ssafyGit.restaurant;

public interface IReviewManager {

    public boolean addReview(Review review);

    public boolean removeReview(int reviewId);

    public Review[] getReviewList();

    public Review searchByreviewId(int reviewId);

    public Review[] getRestaurantReview(int resId);
}
