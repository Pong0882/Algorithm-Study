package ssafy.ssafyGit.restaurant;

public class Review {
    int reviewId;
    int resid;
    String writer;
    String content;

    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", resid=" + resid + ", writer=" + writer + ", content=" + content
                + "]";
    }

    public Review(int reviewId, int resid, String writer, String content) {
        super();
        this.reviewId = reviewId;
        this.resid = resid;
        this.writer = writer;
        this.content = content;
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public int getResid() {
        return resid;
    }

    public void setResid(int resid) {
        this.resid = resid;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Review() {
        // TODO Auto-generated constructor stub
    }

}
