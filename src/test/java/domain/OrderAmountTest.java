package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class OrderAmountTest {
    @Test
    @DisplayName("같은 수량의 orderamount가 같은 것으로 인식되는지 확인")
    void sameOrderAmount() {
        OrderAmount oa = new OrderAmount(12);
        OrderAmount oa2 = new OrderAmount(12);
        assertThat(oa).isEqualTo(oa2);
    }


    @ParameterizedTest
    @CsvSource({"1", "98", "99"})
    @DisplayName("옳은 주문 수량 입력 테스트")
    void putOrderAmount(int input) {
        OrderAmount oa = new OrderAmount(input);
        assertThat(oa.getOrderAmount()).isEqualTo(input);
    }

    @ParameterizedTest
    @CsvSource({"0", "100", "101"})
    @DisplayName("잘못된 주문 수량 입력 테스트")
    void putWrongOrderAmount(int input) {
        assertThatThrownBy(() -> new OrderAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상 99이하");
    }

    @Test
    @DisplayName("주문 더했을 때 범위 안에 있는지 확인하는 테스트")
    void addedInRightRange() {
        OrderAmount oa = new OrderAmount(1);
        OrderAmount increasedoa = oa.add(98);
        assertThat(increasedoa.getOrderAmount()).isEqualTo(99);
    }

    @Test
    @DisplayName("주문 더했을 때 범위 밖에 있으면 예외 처리")
    void addInWrongRange() {
        OrderAmount oa = new OrderAmount(1);
        assertThatThrownBy(() -> oa.add(99))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("1이상 99이하");
    }

}
