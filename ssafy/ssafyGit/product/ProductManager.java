package ssafy.ssafyGit.product;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductManager {
    private final int MAX_PRODUCT_SIZE = 100;
    private final int MAX_REVIEW_SIZE = 1000;
    private Product[] products = new Product[MAX_PRODUCT_SIZE];
    private Review[] reviews = new Review[MAX_REVIEW_SIZE];
    private int pCount;
    private int rCount;

    public boolean addProduct(Product product) {
        if (pCount < MAX_PRODUCT_SIZE) {
            products[pCount++] = product;
            return true;
        } else {
            return false;
        }
    }

    public boolean updateProduct(Product product) {
        for (int i = 0; i < pCount; i++) {
            if (products[i] == product) {
                products[i] = product;
                return true;
            }
        }
        return false;
    }

    public boolean remove(String pCode) {
        for (int i = 0; i < pCount; i++) {
            if (products[i].getpCode() == pCode) {
                products[i] = products[pCount--];
                return true;
            }
        }
        return false;
    }

    public int sell(String pCode, int cnt) {
        for (int i = 0; i < pCount; i++) {
            if (products[i].getpCode() == pCode) {
                products[i].setQuantity(products[i].getQuantity() - cnt);
                return products[i].getPrice() * cnt;
            }
        }
        return 0;
    }

    public Product[] getProductList() {
        return Arrays.copyOf(products, pCount);
    }

    public Product searchByCode(String pCode) {
        for (int i = 0; i < pCount; i++) {
            if (products[i].getpCode() == pCode) {
                return products[i];
            }
        }
        return null;
    }

    public boolean addReview(Review review) {
        if (rCount < MAX_REVIEW_SIZE) {
            reviews[rCount++] = review;
            return true;
        }
        return false;
    }

    public boolean removeReview(int reviewId) {
        for (int i = 0; i < rCount; i++) {
            if (reviews[i].getReviewId() == reviewId) {
                reviews[i] = reviews[rCount--];
                return true;
            }
        }
        return false;
    }

    public Review[] getProductReview(String pCode) {
        Review[] tmp = new Review[rCount];
        int tmpCount = 0;
        for (int i = 0; i < rCount; i++) {
            if (reviews[i].getpCode().equals(pCode))
                tmp[tmpCount++] = reviews[i];
        }
        return Arrays.copyOf(tmp, tmpCount);
    }

    public Product[] searchByName(String name) {
        Product[] tmp = new Product[pCount];
        int tmpCount = 0;
        for (int i = 0; i < pCount; i++) {
            if (products[i].getpName().contains(name)) {
                tmp[tmpCount++] = products[i];
            }
        }
        return Arrays.copyOf(tmp, tmpCount);
    }

    public Refrigerator[] getRefrigerators() {
        int cnt = 0;
        Refrigerator[] tmp = new Refrigerator[pCount];

        for (int i = 0; i < pCount; i++) {
            if (products[i] instanceof Refrigerator) {
                tmp[cnt++] = (Refrigerator) products[i];
            }
        }
        return Arrays.copyOf(tmp, cnt);
    }

    public Product[] getProducts() {
        int cnt = 0;
        Product[] tmp = new Product[pCount];

        for (int i = 0; i < pCount; i++) {
            if (!(products[i] instanceof Refrigerator)) {
                tmp[cnt++] = products[i];
            }
        }
        return Arrays.copyOf(tmp, cnt);
    }

    public Refrigerator[] getRefrigeratorsFreeze(Boolean freezer) {
        ArrayList<Refrigerator> refrigerators = new ArrayList<>();
        for (Product product : products) {
            if (product instanceof Refrigerator refrigerator) {
                if (freezer == refrigerator.isFreezer()) {
                    refrigerators.add(refrigerator);
                }
            }
        }
        return refrigerators.toArray(new Refrigerator[refrigerators.size()]);
    }

    public long getTotalPrice() {
        int result = 0;
        for (int i = 0; i < pCount; i++) {
            result += products[i].getPrice();
        }
        return result;
    }

}
