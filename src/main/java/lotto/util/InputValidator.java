package lotto.util;

import static lotto.common.constant.Validator.LOTTO_PRICE;
import static lotto.common.constant.Validator.MAX_PURCHASE_AMOUNT;
import static lotto.common.message.ErrorMessage.ERROR_MESSAGE_SUFFIX;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_HAS_STRING;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_TOO_BIG;

public class InputValidator {

    public void purchaseAmount(String input) {
        checkPriceOnlyNumber(input);
    }

    private void checkPriceOnlyNumber(String input) {
        try {
            Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SUFFIX.getMessage()
                    + PURCHASE_AMOUNT_HAS_STRING.getMessage());
        }
    }
}
