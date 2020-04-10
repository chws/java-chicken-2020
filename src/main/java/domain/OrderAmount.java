package domain;

public class OrderAmount {

    private int amount;

    public OrderAmount(int amount) {
        validateAmount(amount);
        this.amount = amount;
    }

    private void validateAmount(int amount) {
        if (amount < 1 || amount > 99) {
            throw new IllegalArgumentException("한 메뉴의 수량은 1이상 99이하이어야 합니다");
        }
    }

    public OrderAmount add(int adder) {
        return new OrderAmount(this.amount + adder);
    }

    public int getOrderAmount() {
        return amount;
    }
}
