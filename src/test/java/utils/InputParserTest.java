package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputParserTest {
    @Test
    @DisplayName("입력 파싱하는 기능 테스트")
    void parse() {
        assertThat(InputParser.parse("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 아닌 입력이 들어갔을 때 예외처리 확인")
    void parseWrongInput() {
        assertThatThrownBy(() -> InputParser.parse("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
