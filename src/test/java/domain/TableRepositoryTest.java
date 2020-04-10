package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TableRepositoryTest {
    @Test
    @DisplayName("테이블 번호로 테이블 찾아서 가져오기 기능 테스트")
    void getTableByTableNo() {
        Table table = TableRepository.of(8);
        assertThat(TableRepository.of(8)).isEqualTo(table);
    }
}
