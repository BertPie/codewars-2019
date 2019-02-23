package pl.piesniak.kyu6.findmultiples;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMultiplesTest {

    private FindMultiples testObj = new FindMultiples();

    @Test
    void solution() {
        // given
        int number = 10;
        int expected = 23;

        // when
        int result = testObj.solution(number);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void solution2() {
        // given
        int number = 4;
        int expected = 3;

        // when
        int result = testObj.solution(number);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void solution3() {
        // given
        int number = 6;
        int expected = 8;

        // when
        int result = testObj.solution(number);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}