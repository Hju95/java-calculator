package Calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Executable;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {


    static int calculate(String input) {
        if (input.isEmpty()) {
            return 0;
        }

        String delimiter = ",|:";
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterIndex);
            input = input.substring(delimiterIndex + 1);
        }

        String[] numbers = input.split(delimiter);
        int sum = 0;
        for (String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                throw new RuntimeException("음수는 입력할 수 없습니다.");
            }
            sum += Integer.parseInt(number);
        }
        return sum;
    }


    @Test
    @DisplayName("공백 넣었을 때 0 반환")
    void emptyInput_ShouldReturnZero() {
        int result = calculate("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName(", 문자 확인")
    void defaultDelimiter_ShouldReturnExpectedSum() {
        assertEquals(6, calculate("1,2,3"));
    }

    @Test
    @DisplayName(": 문자 확인")
    void defaultDelimiter_ShouldReturnExpectedSum2() {
        assertEquals(6, calculate("1:2:3"));
    }

    @Test
    @DisplayName("복합 문자 확인")
    void defaultDelimiter_ShouldReturnExpectedSum3() {
        assertEquals(6, calculate("1,2:3"));
    }

    @Test
    @DisplayName("커스텀 문자 확인")
    void customDelimiter_ShouldReturnExpectedSum() {
        assertEquals(6, calculate("//;\n1;2;3"));
    }

    @Test
    @DisplayName("음수 확인")
    void invalidInput_ShouldReturnNull() {
        assertThrows(RuntimeException.class, () -> calculate("1,-2,3"));
    }

    @Test
    @DisplayName("문자 확인")
    void invalidInput_ShouldReturnNull2() {
        assertThrows(RuntimeException.class, () -> calculate("a,b,3"));
    }

}
