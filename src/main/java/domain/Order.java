package domain;

public class Order {
    private final Menu menu;
    private OrderAmount amount;

    public Order(Menu menu, OrderAmount amount) {
        this.menu = menu;
        this.amount = amount;
    }

    public void addAmount(int adder) {
        amount = amount.add(adder);
    }

    public Menu getMenu() {
        return menu;
    }

    public OrderAmount getOrderAmount() {
        return amount;
    }
}
