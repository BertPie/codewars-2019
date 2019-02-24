package pl.piesniak.kyu4.morsecode2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

class MorseCodeDecoderTest {

    @Test
    @DisplayName("Double time - HEY JUDE")
    void provided() {
        // given
        String bits = "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011";
        String expected = ".... . -.--   .--- ..- -.. .";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("testExtraZerosHandling - 1 @beginning")
    void mine2() {
        // given
        String bits = "0111";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("testExtraZerosHandling - 2 @beginning")
    void mine5() {
        // given
        String bits = "00111";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
    @Test
    @DisplayName("testExtraZerosHandling - 3 @beginning")
    void mine6() {
        // given
        String bits = "000111";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("testExtraZerosHandling - 5 @beginning")
    void mine7() {
        // given
        String bits = "00000111";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("testExtraZerosHandling - 1 @ending")
    void mine8() {
        // given
        String bits = "1110";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("testExtraZerosHandling - 2 @ending")
    void mine9() {
        // given
        String bits = "11100";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("testExtraZerosHandling - 3 @ending")
    void mine10() {
        // given
        String bits = "111000";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("testExtraZerosHandling - 5 @ending")
    void mine11() {
        // given
        String bits = "11100000";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("testExtraZerosHandling")
    void provided2() {
        // given
        String bits = "0000111000000";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("dot")
    void provided3() {
        // given
        String bits = "1";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("testLongMessagesHandling")
    void testLongMessagesHandling() {
        // given
        String bits = "00011100010101010001000000011101110101110001010111000101000111010111010001110101110000000111010101000101110100011101110111000101110111000111010000000101011101000111011101110001110101011100000001011101110111000101011100011101110001011101110100010101000000011101110111000101010111000100010111010000000111000101010100010000000101110101000101110001110111010100011101011101110000000111010100011101110111000111011101000101110101110101110";
        String expected = "- .... .   --.- ..- .. -.-. -.-   -... .-. --- .-- -.   ..-. --- -..-   .--- ..- -- .--. ...   --- ...- . .-.   - .... .   .-.. .- --.. -.--   -.. --- --. .-.-.-";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("111")
    void provided6() {
        // given
        String bits = "111";
        String expected = ".";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("HH")
    void mine() {
        // given
        String bits = "10101010001010101";
        String expected = ".... ....";

        // when
        String result = MorseCodeDecoder.decodeBits(bits);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    // test private methods --------------------------------------------------------------------------------------------

    @Test
    void findHighestCommonDenominator() {
        // given
        List<Integer> list = List.of(2, 2, 2, 2, 2, 2, 2, 6, 2, 6, 6, 2, 2, 2, 6, 2, 6, 14, 2, 2, 6, 2, 6, 2, 6, 6, 2, 2, 2, 2, 6, 6, 6, 2, 2, 2, 2, 6, 2);
        int expected = 2;

        // when
        int result = MorseCodeDecoder.findHighestCommonDenominator(list);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void findHighestCommonDenominator2() {
        // given
        List<Integer> list = List.of(3, 3, 9);
        int expected = 3;

        // when
        int result = MorseCodeDecoder.findHighestCommonDenominator(list);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void getNextBit() {
        // given
        String bits = "10101010001010101";
        int cursor = 0;
        int length = 1;
        String expected = "0";

        // when
        String result = MorseCodeDecoder.getNextBit(bits, cursor, length);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void getNextBit2() {
        // given
        String bits = "10101010001010101";
        int cursor = 7;
        int length = 1;
        String expected = "0";

        // when
        String result = MorseCodeDecoder.getNextBit(bits, cursor, length);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("getNextNumber")
    void getNextNumber() {
        // given
        String bits = "10101010001010101";
        int cursor = 0;
        int expected = 1;

        // when
        int result = MorseCodeDecoder.getNextNumber(bits, cursor);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("getNextNumber")
    void getNextNumber2() {
        // given
        String bits = "10101010001010101";
        int cursor = 7;
        int expected = 3;

        // when
        int result = MorseCodeDecoder.getNextNumber(bits, cursor);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void decodeList() {
        // given
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1); //1
        list.add(1); //0
        list.add(1); //1
        list.add(1); //0
        list.add(1); //1
        list.add(1); //0
        list.add(1); //1
        String expected = "....";

        // when
        String result = MorseCodeDecoder.listToMorse(list);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void decodeList2() {
        // given
        List<Integer> list = new LinkedList<>();
        list.add(1); //1
        list.add(3); //0
        list.add(1); //1
        list.add(3); //0
        list.add(1); //1
        list.add(1); //0
        list.add(1); //1
        String expected = ". . ..";

        // when
        String result = MorseCodeDecoder.listToMorse(list);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    void bitsToList() {
        // given
        String bits = "01001";
        int expectedLength = 4;

        // when
        List<Integer> result = MorseCodeDecoder.bitsToIntList(bits);

        // then
        Assertions.assertThat(result.size()).isEqualTo(expectedLength);
    }

    @Test
    void bitsToList2() {
        // given
        String bits = "0";
        int expectedLength = 1;
        int firstNumber = 1;

        // when
        List<Integer> result = MorseCodeDecoder.bitsToIntList(bits);

        // then
        Assertions.assertThat(result.size()).isEqualTo(expectedLength);
        Assertions.assertThat(result.get(0)).isEqualTo(firstNumber);
    }

    @Test
    void bitsToList3() {
        // given
        String bits = "000000000000";
        int expectedLength = 1;
        int firstNumber = 12;

        // when
        List<Integer> result = MorseCodeDecoder.bitsToIntList(bits);

        // then
        Assertions.assertThat(result.size()).isEqualTo(expectedLength);
        Assertions.assertThat(result.get(0)).isEqualTo(firstNumber);
    }

    @Test
    void bitsToList4() {
        // given
        String bits = "1100110011001100000011000000111111001100111111001111110000000000000011001111110011111100111111000000110011001111110000001111110011001100000011";
        int expectedLength = 39;
        int firstNumber = 2;

        // when
        List<Integer> result = MorseCodeDecoder.bitsToIntList(bits);

        // then
        Assertions.assertThat(result.size()).isEqualTo(expectedLength);
        Assertions.assertThat(result.get(0)).isEqualTo(firstNumber);
    }
}