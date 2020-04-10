package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {
    @Test
    @DisplayName("테이블에 주문이 들어가는 것 테스트")
    void addOrderToTable() {
        Table table = TableRepository.of(8);
        Menu menu = MenuRepository.of(21);
        OrderAmount orderAmount = new OrderAmount(2);
        table.addOrder(menu, orderAmount);
        Map<Menu, OrderAmount> orders = table.getOrders();
        assertThat(orders.get(menu)).isEqualTo(new OrderAmount(2));
    }

    @Test
    @DisplayName("계산 안 된 주문이 한 테이블에 있는지 확인")
    void hasUnpaidOrders() {
        Table table = TableRepository.of(5);
        Menu menu = MenuRepository.of(21);
        OrderAmount orderAmount = new OrderAmount(2);
        table.addOrder(menu, orderAmount);

        assertThat(table.hasUnpaidOrders()).isTrue();
    }
}
