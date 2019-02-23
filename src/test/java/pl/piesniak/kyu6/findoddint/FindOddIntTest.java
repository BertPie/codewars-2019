package pl.piesniak.kyu6.findoddint;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindOddIntTest {

    @Test
    @DisplayName("example 1")
    void findIt() {
        // given
        int[] a = new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5};
        int expected = 5;

        // when
        int result = FindOddInt.findIt(a);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("example 2")
    void findIt2() {
        // given
        int[] a = new int[]{1,1,2,-2,5,2,4,4,-1,-2,5};
        int expected = -1;

        // when
        int result = FindOddInt.findIt(a);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("example 3")
    void findIt3() {
        // given
        int[] a = new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5};
        int expected = 5;

        // when
        int result = FindOddInt.findIt(a);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("example 4")
    void findIt4() {
        // given
        int[] a = new int[]{10};
        int expected = 10;

        // when
        int result = FindOddInt.findIt(a);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("example 5")
    void findIt5() {
        // given
        int[] a = new int[]{1,1,1,1,1,1,10,1,1,1,1};
        int expected = 10;

        // when
        int result = FindOddInt.findIt(a);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("example 6")
    void findIt6() {
        // given
        int[] a = new int[]{5,4,3,2,1,5,4,3,2,10,10};
        int expected = 1;

        // when
        int result = FindOddInt.findIt(a);

        // then
        assertThat(result).isEqualTo(expected);
    }
}