package domain;

import java.util.Objects;

public class OrderAmount {

    private int orderAmount;

    public OrderAmount(int orderAmount) {
        validateAmount(orderAmount);
        this.orderAmount = orderAmount;
    }

    private void validateAmount(int orderAmount) {
        if (orderAmount < 1 || orderAmount > 99) {
            throw new IllegalArgumentException("한 메뉴의 수량은 1이상 99이하이어야 합니다");
        }
    }

    public OrderAmount add(int adder) {
        return new OrderAmount(this.orderAmount + adder);
    }

    public int getOrderAmount() {
        return orderAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderAmount that = (OrderAmount) o;
        return orderAmount == that.orderAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderAmount);
    }
}
