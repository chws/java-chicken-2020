package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuRepositoryTest {
    @ParameterizedTest
    @CsvSource({"1", "2", "3", "4", "5", "6", "21", "22"})
    @DisplayName("옳은 메뉴 번호로 메뉴 찾아서 가져올 때 계속 같은 객체인지 확인")
    void getMenuByMenuNo(int menuNo) {
        Menu menu = MenuRepository.of(menuNo);
        assertThat(MenuRepository.of(menuNo)).isEqualTo(menu);
    }

    @ParameterizedTest
    @CsvSource({"0", "7", "20", "23", "25"})
    @DisplayName("잘못된 메뉴 번호로 메뉴 가져오기 테스트")
    void getWrongMenuNo(int menuNo) {
        assertThatThrownBy(() -> MenuRepository.of(menuNo))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("메뉴는 존재하지");
    }
}
