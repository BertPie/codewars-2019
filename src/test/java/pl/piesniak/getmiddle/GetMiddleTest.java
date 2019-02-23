package pl.piesniak.getmiddle;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GetMiddleTest {

    @Test
    @DisplayName("even - test")
    void ev1() {
        //given
        String word = "test";
        String expected = "es";

        //when
        String result = GetMiddle.getMiddle(word);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("even - middle")
    void ev2() {
        //given
        String word = "middle";
        String expected = "dd";

        //when
        String result = GetMiddle.getMiddle(word);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("odd - testing")
    void odd1() {
        //given
        String word = "testing";
        String expected = "t";

        //when
        String result = GetMiddle.getMiddle(word);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("odd - A")
    void odd2() {
        //given
        String word = "A";
        String expected = "A";

        //when
        String result = GetMiddle.getMiddle(word);

        //then
        Assertions.assertThat(result).isEqualTo(expected);
    }

}