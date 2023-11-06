package study;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

    /**
     * 요구사항 1
     * "1,2"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     */
    @DisplayName("요구사항 1-1번")
    @Test
    void split_should_return_expected_values() {
        String input = "1,2";
        String[] expected = {"1", "2"};

        String[] actual = input.split(",");

        assertThat(actual).contains("1");
        assertThat(actual).containsExactly(expected);
    }

    @DisplayName("요구사항 1-2번")
    @Test
    void split_should_return_one_element_array() {
        String input = "1";
        String[] expected = {"1"};

        String[] actual = input.split(",");

        assertThat(actual).containsExactly(expected);
    }

    /**
     * 요구사항 2
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거하고 "1,2"를 반환
     * 하도록 구현한다
     */
    @DisplayName("요구사항 2번")
    @Test
    void remove_brackets_should_return_expected_value() {
        String input = "(1,2)";

        String actual = input.substring(1, input.length() - 1);

        Assertions.assertEquals("1,2", actual);
    }

    /**
     * 요구사항 3
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습
     * 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면
     * StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다
     */
    @Test
    @DisplayName("요구사항 3번")
    public void testValidCharAtPosition() {
        String text = "abc";

        // Testing valid character retrieval
        assertThat(text.charAt(0)).isEqualTo('a');
        assertThat(text.charAt(1)).isEqualTo('b');
        assertThat(text.charAt(2)).isEqualTo('c');

        assertThatThrownBy(() -> text.charAt(3))
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                    .hasMessageContaining("out of range: 3");

    }

}
