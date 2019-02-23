package pl.piesniak.kyu6.morsecode;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MorseCodedecoderTest {

    @Test
    @DisplayName("Three spaces between words")
    void provided() {
        // given
        String morseCode = ".... . -.--   .--- ..- -.. .";
        String expected = "HEY JUDE";

        // when
        String result = MorseCodedecoder.decode(morseCode);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Four spaces between words")
    void mine1() {
        // given
        String morseCode = ".... . -.--    .--- ..- -.. .";
        String expected = "HEY JUDE";

        // when
        String result = MorseCodedecoder.decode(morseCode);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Start with space")
    void mine2() {
        // given
        String morseCode = " ....   ....";
        String expected = "H H";

        // when
        String result = MorseCodedecoder.decode(morseCode);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Ends with one space")
    void mine3() {
        // given
        String morseCode = "....   .... ";
        String expected = "H H";

        // when
        String result = MorseCodedecoder.decode(morseCode);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("Ends with two spaces")
    void mine4() {
        // given
        String morseCode = "....   ....  ";
        String expected = "H H";

        // when
        String result = MorseCodedecoder.decode(morseCode);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}