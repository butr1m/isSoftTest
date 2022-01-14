package entity;

public class OrderData {
    private String orderId;
    private String orderDate;

    public OrderData(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return orderId+":"+orderDate+"\n";
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
}
