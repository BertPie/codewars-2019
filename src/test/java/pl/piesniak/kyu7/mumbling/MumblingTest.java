package pl.piesniak.kyu7.mumbling;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MumblingTest {

    @Test
    @DisplayName("ZpglnRxqenU")
    void t1(){
        // given
        String s = "ZpglnRxqenU";
        String expected = "Z-Pp-Ggg-Llll-Nnnnn-Rrrrrr-Xxxxxxx-Qqqqqqqq-Eeeeeeeee-Nnnnnnnnnn-Uuuuuuuuuuu";

        // when
        String result = Mumbling.accum(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("NyffsGeyylB")
    void t2(){
        // given
        String s = "NyffsGeyylB";
        String expected = "N-Yy-Fff-Ffff-Sssss-Gggggg-Eeeeeee-Yyyyyyyy-Yyyyyyyyy-Llllllllll-Bbbbbbbbbbb";

        // when
        String result = Mumbling.accum(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("MjtkuBovqrU")
    void t3(){
        // given
        String s = "MjtkuBovqrU";
        String expected = "M-Jj-Ttt-Kkkk-Uuuuu-Bbbbbb-Ooooooo-Vvvvvvvv-Qqqqqqqqq-Rrrrrrrrrr-Uuuuuuuuuuu";
        // when
        String result = Mumbling.accum(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("EvidjUnokmM")
    void t4(){
        // given
        String s = "EvidjUnokmM";
        String expected = "E-Vv-Iii-Dddd-Jjjjj-Uuuuuu-Nnnnnnn-Oooooooo-Kkkkkkkkk-Mmmmmmmmmm-Mmmmmmmmmmm";
        // when
        String result = Mumbling.accum(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("HbideVbxncC")
    void t5(){
        // given
        String s = "HbideVbxncC";
        String expected = "H-Bb-Iii-Dddd-Eeeee-Vvvvvv-Bbbbbbb-Xxxxxxxx-Nnnnnnnnn-Cccccccccc-Ccccccccccc";

        // when
        String result = Mumbling.accum(s);

        // then
        Assertions.assertThat(result).isEqualTo(expected);
    }
}