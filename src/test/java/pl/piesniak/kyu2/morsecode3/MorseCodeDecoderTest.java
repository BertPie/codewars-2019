package pl.piesniak.kyu2.morsecode3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MorseCodeDecoderTest {

    @Test
    @DisplayName("'HEY JUDE', variable rate, 0 @both")
    void provided() {
        // given
        String bits = "0000000011011010011100000110000001111110100111110011111100000000000111011111111011111011111000000101100011111100000111110011101100000100000";
        String expected = ".... . -.--   .--- ..- -.. .";

        // when
        String result = MorseCodeDecoder.decodeBitsAdvanced(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }
}