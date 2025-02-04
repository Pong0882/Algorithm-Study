package ssafy.ssafyGit.product.interfaceversion;

public interface IProductManager {
    boolean addProduct(Product product);

    boolean updateProduct(Product product);

    public boolean removeProduct(String pCode);

    public int sell(String pCode, int cnt);

    public Product[] getProductList();

    public Product searchByCode(String pCode);

    public boolean addReview(Review review);

    public boolean removeReview(int reviewId);

    public Review[] getProductReview(String pCode);

    public Product[] searchByName(String name);

    public Refrigerator[] getRefrigerators();

    public Product[] getProducts();

    public Refrigerator[] getRefrigeratorsFreeze(Boolean freezer);

    public long getTotalPrice();
}
