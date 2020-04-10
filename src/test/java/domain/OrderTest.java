package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderTest {
    Order order;

    @BeforeEach
    void initialize() {
        order = new Order(MenuRepository.of(1), new OrderAmount(2));
    }

    @Test
    @DisplayName("주문 추가 테스트")
    void addOrderAmountToOrder() {
        order.addAmount(97);
        assertThat(order.getOrderAmount()).isEqualTo(new OrderAmount(99));
    }

    @Test
    @DisplayName("추가 주문했을 때 수량 넘으면 예외처리")
    void addOrderTooMuch() {
        assertThatThrownBy(() -> order.addAmount(98))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상 99이하");
    }
}
