package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {

    Table table;
    Menu menu;
    OrderAmount orderAmount;

    @BeforeEach
    void init() {
        table = TableRepository.of(8);
        menu = MenuRepository.of(21);
        orderAmount = new OrderAmount(2);
    }

    @Test
    @DisplayName("테이블에 주문이 들어가는 것 테스트")
    void addOrderToTable() {
        table.addOrder(menu, orderAmount);
        Map<Menu, OrderAmount> orders = table.getOrders();
        assertThat(orders.get(menu)).isEqualTo(new OrderAmount(2));
    }

    @Test
    @DisplayName("기존 테이블 주문에 주문 더하는 것 테스트-같은 메뉴 더")
    void addOrderToSameMenuTableTest() {
        table.addOrder(menu, orderAmount);
        OrderAmount increment = new OrderAmount(10);
        table.addOrder(menu, increment);
        Map<Menu, OrderAmount> orders = table.getOrders();
        assertThat(orders.get(menu)).isEqualTo(new OrderAmount(12));
    }

    @Test
    @DisplayName("기존 테이블 주문에 주문 더하는 것 테스트-다른 메뉴 추가")
    void addOrderToDiffMenuTableTest() {
        table.addOrder(menu, orderAmount);
        Menu diffMenu = MenuRepository.of(3);
        OrderAmount diffAmount = new OrderAmount(4);
        table.addOrder(diffMenu, diffAmount);
        Map<Menu, OrderAmount> orders = table.getOrders();
        assertThat(orders.get(menu)).isEqualTo(new OrderAmount(2));
        assertThat(orders.get(diffMenu)).isEqualTo(new OrderAmount(4));
    }

    @Test
    @DisplayName("계산 안 된 주문이 한 테이블에 있는지 확인")
    void hasUnpaidOrders() {
        table.addOrder(menu, orderAmount);
        assertThat(table.hasUnpaidOrders()).isTrue();
    }
}
