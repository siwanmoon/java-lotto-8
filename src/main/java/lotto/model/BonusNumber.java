package lotto.model;

import static lotto.common.Strategy.LOTTO_MAX_NUMBER;
import static lotto.common.Strategy.LOTTO_MIN_NUMBER;
import static lotto.common.message.ErrorMessage.BONUS_NUMBER_DECIMAL;
import static lotto.common.message.ErrorMessage.BONUS_NUMBER_HAS_STRING;
import static lotto.common.message.ErrorMessage.BONUS_NUMBER_OVER_MAX_NUMBER;
import static lotto.common.message.ErrorMessage.BONUS_NUMBER_UNDER_MIN_NUMBER;
import static lotto.common.message.ErrorMessage.ERROR_MESSAGE_PREFIX;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(String input) {
        this.bonusNumber = (int) validate(input);
    }

    private double validate(String input) {
        double bonusNumber = changeInputNumeric(input);
        checkRange(bonusNumber);
        checkNotDecimal(bonusNumber);

        return bonusNumber;
    }

    private double changeInputNumeric(String input) {
        double bonusNumber;

        try {
            bonusNumber = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ERROR_MESSAGE_PREFIX.getMessage()
                    + BONUS_NUMBER_HAS_STRING.getMessage());
        }

        return bonusNumber;
    }

    private void checkRange(double input) {
        if (Double.isInfinite(input) || input > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_OVER_MAX_NUMBER.getMessage());
        }

        if (input < LOTTO_MIN_NUMBER) {
            throw new IllegalArgumentException(BONUS_NUMBER_UNDER_MIN_NUMBER.getMessage());
        }
    }

    private void checkNotDecimal(double input) {
        if (input % 1 != 0) {
            throw new IllegalArgumentException(BONUS_NUMBER_DECIMAL.getMessage());
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
