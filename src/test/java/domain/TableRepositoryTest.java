package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TableRepositoryTest {
    @ParameterizedTest
    @CsvSource({"1", "2", "3", "5", "6", "8"})
    @DisplayName("테이블 번호로 테이블 찾아서 가져오기 기능 테스트")
    void getTableByTableNo(int menuNo) {
        Table table = TableRepository.of(menuNo);
        assertThat(TableRepository.of(menuNo)).isEqualTo(table);
    }

    @ParameterizedTest
    @CsvSource({"4", "7"})
    @DisplayName("잘못된 테이블 번호로 테이블 가져오기 테스트")
    void getWrongTableNo(int tableNo) {
        assertThatThrownBy(() -> TableRepository.of(tableNo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("테이블은 존재하지");
    }
}
