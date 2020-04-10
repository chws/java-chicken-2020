package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int number;
    private Map<Menu, OrderAmount> orders;

    public Table(final int number) {
        this.number = number;
        this.orders = new HashMap<>();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public int getNumber() {
        return number;
    }

    public boolean hasUnpaidOrders() {
        return orders != null && !orders.isEmpty();
    }

    public void addOrder(Menu menu, OrderAmount orderAmount) {
        if (orders.containsKey(menu)) {
            OrderAmount beforeOrderAmount = orders.get(menu);
            orders.put(menu, beforeOrderAmount.add(orderAmount));
        }
        orders.putIfAbsent(menu, orderAmount);
    }

    public Map<Menu, OrderAmount> getOrders() {
        return orders;
    }
}
