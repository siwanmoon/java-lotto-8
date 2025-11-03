package lotto.model;

import static lotto.common.message.ErrorMessage.INVALID_LOTTO_SIZE;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_DECIMAL;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_NOT_BLANK;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_NOT_NUMERIC;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.common.message.ErrorMessage.LOTTO_NUMBER_TOO_BIG;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class LottoTest {
    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효한_문자열로_Lotto_of를_호출하면_객체_생성에_성공한다() {
        String input = "1,2,3,4,5,6";
        Lotto lotto = Lotto.of(input);

        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getNumbers()).isEqualTo(expectedNumbers);
    }

    @Test
    void 유효한_리스트로_Lotto_생성자를_호출하면_객체_생성에_성공한다() {
        List<Integer> inputList = List.of(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(inputList);

        assertThat(lotto.getNumbers()).isEqualTo(inputList);
    }

    @Test
    void 생성시_로또_번호가_자동으로_정렬된다() {
        List<Integer> inputList = List.of(6, 5, 4, 3, 2, 1);
        Lotto lotto = new Lotto(inputList);

        List<Integer> expectedNumbers = List.of(1, 2, 3, 4, 5, 6);
        assertThat(lotto.getNumbers()).isEqualTo(expectedNumbers);
    }

    @Test
    void 로또_번호의_개수가_6개가_아니면_예외가_발생한다() {
        String inputShort = "1,2,3,4,5";
        assertThatThrownBy(() -> Lotto.of(inputShort))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_SIZE.getMessage());

        String inputLong = "1,2,3,4,5,6,7";
        assertThatThrownBy(() -> Lotto.of(inputLong))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_SIZE.getMessage());

        List<Integer> listShort = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(listShort))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(INVALID_LOTTO_SIZE.getMessage());
    }

    @Test
    void 로또_번호가_1부터_45_범위를_벗어나면_예외가_발생한다() {
        String inputUnder = "0,1,2,3,4,5";
        assertThatThrownBy(() -> Lotto.of(inputUnder))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());

        String inputOver = "46,1,2,3,4,5";
        assertThatThrownBy(() -> Lotto.of(inputOver))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());

        List<Integer> listOver = List.of(46, 1, 2, 3, 4, 5);
        assertThatThrownBy(() -> new Lotto(listOver))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @Test
    void 로또_번호에_숫자가_아닌_문자가_있으면_예외가_발생한다() {
        String input = "1,2,3,a,5,6";
        assertThatThrownBy(() -> Lotto.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_NOT_NUMERIC.getMessage());
    }

    @Test
    void 로또_번호에_공백이_입력되면_예외가_발생한다() {
        String inputBlank = "1,2, ,4,5,6";
        assertThatThrownBy(() -> Lotto.of(inputBlank))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_NOT_BLANK.getMessage());

        String inputEmpty = "1,2,,4,5,6";
        assertThatThrownBy(() -> Lotto.of(inputEmpty))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_NOT_BLANK.getMessage());
    }

    @Test
    void 로또_번호에_소수가_입력되면_예외가_발생한다() {
        String input = "1.5,2,3,4,5,6";
        assertThatThrownBy(() -> Lotto.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_DECIMAL.getMessage());
    }

    @Test
    void 로또_번호가_int_범위를_벗어나면_예외가_발생한다() {
        String input = "1,2,3,4,5,99999999999";
        assertThatThrownBy(() -> Lotto.of(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LOTTO_NUMBER_TOO_BIG.getMessage());
    }

    @Test
    void contains_메서드가_정확히_동작한다() {
        Lotto lotto = Lotto.of("1,2,3,4,5,6");

        assertThat(lotto.contains(1)).isTrue();
        assertThat(lotto.contains(7)).isFalse();
    }

    @Test
    void countMatches_메서드가_정확히_동작한다() {
        Lotto lotto1 = Lotto.of("1,2,3,4,5,6");
        Lotto lotto2 = Lotto.of("4,5,6,7,8,9");

        assertThat(lotto1.countMatches(lotto2)).isEqualTo(3);

        Lotto lotto3 = Lotto.of("10,11,12,13,14,15");
        assertThat(lotto1.countMatches(lotto3)).isEqualTo(0);
    }
}
