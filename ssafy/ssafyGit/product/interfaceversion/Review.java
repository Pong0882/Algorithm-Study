package ssafy.ssafyGit.product.interfaceversion;

public class Review {
    private int reviewId;
    private String pCode;
    private String writer;
    private String content;

    public Review() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Review(int reviewId, String pCode, String writer, String content) {
        super();
        this.reviewId = reviewId;
        this.pCode = pCode;
        this.writer = writer;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Review [reviewId=" + reviewId + ", pCode=" + pCode + ", writer=" + writer + ", content=" + content
                + "]";
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
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
}
