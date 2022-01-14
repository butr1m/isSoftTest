package entity;

public class ProductData {
    private String productId;
    private String productName;
    private int pricePerUnit;

    public ProductData(String productId, String productName, int pricePerUnit) {
        this.productId = productId;
        this.productName = productName;
        this.pricePerUnit = pricePerUnit;
    }

    @Override
    public String toString() {
        return productId+","+productName+","+pricePerUnit;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(int pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }
}
