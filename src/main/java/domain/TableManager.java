package domain;

import java.util.Map;

public class TableManager {
    public int calculateTablePayment(Table table, MethodOfPayment methodOfPayment) {
        Map<Menu, OrderAmount> orders = table.getOrders();
        int totalPrice = calculateTotalPrice(orders);
        int chickenCount = getChickenDiscount(orders);
        int discount = chickenCount * 10000;
        totalPrice = totalPrice - discount;
        totalPrice = discountMethodOfPayment(methodOfPayment, totalPrice);
        return totalPrice;
    }

    private int discountMethodOfPayment(MethodOfPayment methodOfPayment, int totalPrice) {
        if (methodOfPayment == MethodOfPayment.CASH) {
            totalPrice = (int) (totalPrice * 0.95);
        }
        return totalPrice;
    }

    private int calculateTotalPrice(Map<Menu, OrderAmount> orders) {
        int totalPrice = 0;
        for (Menu menu : orders.keySet()) {
            OrderAmount orderAmount = orders.get(menu);
            totalPrice += menu.getPrice() * orderAmount.getOrderAmount();
        }
        return totalPrice;
    }

    private int getChickenDiscount(Map<Menu, OrderAmount> orders) {
        int chickenCount = 0;
        for (Menu menu : orders.keySet()) {
            if (menu.isChicken()) {
                chickenCount += 1;
            }
        }
        chickenCount = chickenCount / 10;
        return chickenCount;
    }
}
