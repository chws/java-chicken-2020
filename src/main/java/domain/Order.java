package domain;

public class Order {
    private Menu menu;
    private OrderAmount amount;

    public Order(Menu menu, OrderAmount amount) {
        this.menu = menu;
        this.amount = amount;
    }

}
