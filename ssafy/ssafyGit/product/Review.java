package ssafy.ssafygit.product;

public class Review {
    public int reviewId;
    public String pCode;
    public String writer;
    public String content;

    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", pCode=" + pCode + ", writer=" + writer + ", content=" + content
                + "]";
    }

    public Review() {
        super();
    }

    public Review(int reviewId, String pCode, String writer, String content) {
        this.reviewId = reviewId;
        this.pCode = pCode;
        this.writer = writer;
        this.content = content;
    }

}
