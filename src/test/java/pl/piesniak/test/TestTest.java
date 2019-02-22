package pl.piesniak.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class TestTest {

    @Test
    @DisplayName("True is true")
    void test(){
        // given
        // when
        // then
        assertThat(true).isEqualTo(true);
    }

}