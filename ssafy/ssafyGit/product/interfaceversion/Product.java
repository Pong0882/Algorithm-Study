package ssafy.ssafyGit.product.interfaceversion;

public class Product {

    private String pCode;
    private String pName;
    private int price;
    private int quantity;
    private String brand;

    public Product(String pCode, String pName, int price, int quantity, String brand, String desc) {
        super();
        this.pCode = pCode;
        this.pName = pName;
        this.price = price;
        this.quantity = quantity;
        this.brand = brand;
        this.desc = desc;
    }

    private String desc;

    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    @Override
    public String toString() {
        return "Product [pCode=" + pCode + ", pName=" + pName + ", brand=" + brand + ", desc=" + desc + ", price="
                + price + ", quantity=" + quantity + "]";
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
