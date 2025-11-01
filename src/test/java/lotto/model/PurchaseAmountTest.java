package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static lotto.common.message.ErrorMessage.ERROR_MESSAGE_PREFIX;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_HAS_STRING;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_TOO_BIG;

import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @Test
    void 유효한_금액을_입력하면_객체_생성에_성공한다() {
        String input = "8000";
        PurchaseAmount purchaseAmount = new PurchaseAmount(input);
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(8000L);
    }

    @Test
    void 유효한_금액_2000_0원을_입력해도_객체_생성에_성공한다() {
        String input = "2000.0";
        PurchaseAmount purchaseAmount = new PurchaseAmount(input);
        assertThat(purchaseAmount.getPurchaseAmount()).isEqualTo(2000L);
    }

    @Test
    void 숫자가_아닌_문자가_포함되면_예외가_발생한다() {
        String expectedMessage = ERROR_MESSAGE_PREFIX.getMessage() + PURCHASE_AMOUNT_HAS_STRING.getMessage();

        assertThatThrownBy(() -> new PurchaseAmount("1000j"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);

        assertThatThrownBy(() -> new PurchaseAmount("abc"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);

        assertThatThrownBy(() -> new PurchaseAmount("1,000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    void 영원_이하의_금액을_입력하면_예외가_발생한다() {
        String expectedMessage = ERROR_MESSAGE_PREFIX.getMessage() + PURCHASE_AMOUNT_NOT_POSITIVE.getMessage();

        assertThatThrownBy(() -> new PurchaseAmount("0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);

        assertThatThrownBy(() -> new PurchaseAmount("-1000"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);

        assertThatThrownBy(() -> new PurchaseAmount("0.0"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    void 천원_단위가_아닌_금액을_입력하면_예외가_발생한다() {
        String expectedMessage = ERROR_MESSAGE_PREFIX.getMessage() + PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage();

        assertThatThrownBy(() -> new PurchaseAmount("1001"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);

        assertThatThrownBy(() -> new PurchaseAmount("1500"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);

        assertThatThrownBy(() -> new PurchaseAmount("1000.5"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    void 최대_구매_금액보다_큰_금액을_입력하면_예외가_발생한다() {
        String input = "8145061000";
        String expectedMessage = ERROR_MESSAGE_PREFIX.getMessage() + PURCHASE_AMOUNT_TOO_BIG.getMessage();

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    @Test
    void Infinity로_파싱되는_매우_큰_숫자를_입력하면_예외가_발생한다() {
        String input = "9999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999";
        String expectedMessage = ERROR_MESSAGE_PREFIX.getMessage() + PURCHASE_AMOUNT_TOO_BIG.getMessage();

        assertThatThrownBy(() -> new PurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }
}
