package lotto.model;

import static lotto.common.message.ErrorMessage.BONUS_NUMBER_DECIMAL;
import static lotto.common.message.ErrorMessage.BONUS_NUMBER_HAS_STRING;
import static lotto.common.message.ErrorMessage.BONUS_NUMBER_OVER_MAX_NUMBER;
import static lotto.common.message.ErrorMessage.BONUS_NUMBER_UNDER_MIN_NUMBER;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class BonusNumberTest {

    @Test
    void 유효한_보너스_번호를_입력하면_객체_생성에_성공한다() {
        BonusNumber bonusNumber1 = new BonusNumber("7");
        assertThat(bonusNumber1.getBonusNumber()).isEqualTo(7);

        BonusNumber bonusNumber2 = new BonusNumber("45.0");
        assertThat(bonusNumber2.getBonusNumber()).isEqualTo(45);
    }

    @Test
    void 숫자가_아닌_문자가_입력되면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_HAS_STRING.getMessage());

        assertThatThrownBy(() -> new BonusNumber("1k2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_HAS_STRING.getMessage());
    }

    @Test
    void 보너스_번호가_45보다_크면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("46"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_OVER_MAX_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호가_1보다_작으면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_UNDER_MIN_NUMBER.getMessage());

        assertThatThrownBy(() -> new BonusNumber("-1"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_UNDER_MIN_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호가_소수이면_예외가_발생한다() {
        assertThatThrownBy(() -> new BonusNumber("1.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DECIMAL.getMessage());
    }

    @Test
    void 보너스_번호가_무한값이면_예외가_발생한다() {
        String infinityInput = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        assertThatThrownBy(() -> new BonusNumber(infinityInput))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_OVER_MAX_NUMBER.getMessage());
    }
}
