package lotto.model;

import static lotto.common.Strategy.LOTTO_PRICE;
import static lotto.common.Strategy.MAX_PURCHASE_AMOUNT;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_HAS_STRING;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_NOT_BLANK;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_TOO_BIG;

public class PurchaseAmount {

    private final long purchaseAmount;

    public PurchaseAmount(String input) {
        this.purchaseAmount = (long) validate(input);
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    private double validate(String input) {
        checkNotBlank(input);
        double purchaseAmount = changeInputNumeric(input);
        checkPriceTooBig(purchaseAmount);
        checkPriceNotPositive(purchaseAmount);
        checkAmountIsMultipleOfLottoPrice(purchaseAmount);

        return purchaseAmount;
    }

    private void checkNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_BLANK.getMessage());
        }
    }

    private double changeInputNumeric(String input) {
        double price;

        try {
            price = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_HAS_STRING.getMessage());
        }

        return price;
    }

    private void checkPriceTooBig(double price) {
        if (Double.isInfinite(price) || price > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_TOO_BIG.getMessage());
        }
    }

    private void checkPriceNotPositive(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_POSITIVE.getMessage());
        }
    }

    private void checkAmountIsMultipleOfLottoPrice(double price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }
}
