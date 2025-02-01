package ssafy.ssafygit.product;

public class Product {
    public String pCode;
    public String pName;
    public int price;
    public int quantity;
    public String brand;
    public String desc;

    @Override
    public String toString() {
        return "Product [pCode=" + pCode + ", pName=" + pName + ", price=" + price + ", quantity=" + quantity
                + ", brand=" + brand + ", desc=" + desc + "]";
    }

    public Product() {
        super();
    }

    public Product(String pCode, String pName, int price, int quantity, String brand, String desc) {
        this.pCode = pCode;
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.desc = desc;
    }

}
