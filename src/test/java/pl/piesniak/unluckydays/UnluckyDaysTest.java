package pl.piesniak.unluckydays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UnluckyDaysTest {

    @Test
    @DisplayName("year 2015")
    void test2015(){
        // given
        int year = 2015;
        int expected = 3;

        // when
        int result = UnluckyDays.unluckyDays(year);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("year 2024 with Friday 13th in december")
    void test2024(){
        // given
        int year = 2024;
        int expected = 2;

        // when
        int result = UnluckyDays.unluckyDays(year);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("year 1986")
    void test1986(){
        // given
        int year = 1986;
        int expected = 1;

        // when
        int result = UnluckyDays.unluckyDays(year);

        // then
        assertThat(result).isEqualTo(expected);
    }
}