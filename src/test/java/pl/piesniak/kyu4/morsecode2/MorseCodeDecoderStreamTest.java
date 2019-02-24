package pl.piesniak.kyu4.morsecode2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MorseCodeDecoderStreamTest {

    @Test
    @DisplayName("'HEY JUDE', 2x rate, 0 @none")
    void provided() {
        // given
        String bits = "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011";
        String expected = ".... . -.--   .--- ..- -.. .";

        // when
        String result = MorseCodeDecoderStream.decodeBits(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("'.', 0 @start(1)")
    void mine6() {
        // given
        String bits = "0111";
        String expected = ".";

        // when
        String result = MorseCodeDecoderStream.decodeBits(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("'.', 0 @start(3)")
    void mine7() {
        // given
        String bits = "000111";
        String expected = ".";

        // when
        String result = MorseCodeDecoderStream.decodeBits(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("'.', 0 @end(1)")
    void mine8() {
        // given
        String bits = "1110";
        String expected = ".";

        // when
        String result = MorseCodeDecoderStream.decodeBits(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("'.', 0 @end(3)")
    void mine11() {
        // given
        String bits = "111000";
        String expected = ".";

        // when
        String result = MorseCodeDecoderStream.decodeBits(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("'.', 0 @both")
    void provided2() {
        // given
        String bits = "0000111000000";
        String expected = ".";

        // when
        String result = MorseCodeDecoderStream.decodeBits(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("just 1")
    void provided3() {
        // given
        String bits = "1";
        String expected = ".";

        // when
        String result = MorseCodeDecoderStream.decodeBits(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("long msg, 1x rate, 0 @both")
    void testLongMessagesHandling() {
        // given
        String bits = "00011100010101010001000000011101110101110001010111000101000111010111010001110101110000000111010101000101110100011101110111000101110111000111010000000101011101000111011101110001110101011100000001011101110111000101011100011101110001011101110100010101000000011101110111000101010111000100010111010000000111000101010100010000000101110101000101110001110111010100011101011101110000000111010100011101110111000111011101000101110101110101110";
        String expected = "- .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-";

        // when
        String result = MorseCodeDecoderStream.decodeBits(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("just 111")
    void provided6() {
        // given
        String bits = "111";
        String expected = ".";

        // when
        String result = MorseCodeDecoderStream.decodeBits(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("simple msg, 1x rate, 0 @none")
    void mine() {
        // given
        String bits = "10101010001010101";
        String expected = ".... ....";

        // when
        String result = MorseCodeDecoderStream.decodeBits(bits);

        // then
        assertThat(result).isEqualTo(expected);
    }

    // private methods =================================================================================================
    // trimBits --------------------------------------------------------------------------------------------------------
    @Test
    @DisplayName("trimBits")
    void trimBitsBoth(){
        // given
        String bits = "000100100010";
        String expected = "10010001";

        // when
        String result = MorseCodeDecoderStream.trimBits(bits);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("trimBits - 1 @start")
    void trimBitsStart1(){
        // given
        String bits = "010010001";
        String expected = "10010001";

        // when
        String result = MorseCodeDecoderStream.trimBits(bits);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("trimBits - 2 @start")
    void trimBitsStart2(){
        // given
        String bits = "0010010001";
        String expected = "10010001";

        // when
        String result = MorseCodeDecoderStream.trimBits(bits);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("trimBits - 3 @start")
    void trimBitsStart3(){
        // given
        String bits = "00010010001";
        String expected = "10010001";

        // when
        String result = MorseCodeDecoderStream.trimBits(bits);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("trimBits - 5 @start")
    void trimBitsStart5(){
        // given
        String bits = "0000010010001";
        String expected = "10010001";

        // when
        String result = MorseCodeDecoderStream.trimBits(bits);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("trimBits - 1 @end")
    void trimBitsEnd1(){
        // given
        String bits = "100100010";
        String expected = "10010001";

        // when
        String result = MorseCodeDecoderStream.trimBits(bits);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("trimBits - 2 @end")
    void trimBitsEnd2(){
        // given
        String bits = "1001000100";
        String expected = "10010001";

        // when
        String result = MorseCodeDecoderStream.trimBits(bits);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("trimBits - 3 @end")
    void trimBitsEnd3(){
        // given
        String bits = "10010001000";
        String expected = "10010001";

        // when
        String result = MorseCodeDecoderStream.trimBits(bits);

        //then
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("trimBits - 5 @end")
    void trimBitsEnd5(){
        // given
        String bits = "1001000100000";
        String expected = "10010001";

        // when
        String result = MorseCodeDecoderStream.trimBits(bits);

        //then
        assertThat(result).isEqualTo(expected);
    }
}