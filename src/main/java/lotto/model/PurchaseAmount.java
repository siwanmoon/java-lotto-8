package lotto.model;

import static lotto.common.Strategy.LOTTO_PRICE;
import static lotto.common.Strategy.MAX_PURCHASE_AMOUNT;
import static lotto.common.message.ErrorMessage.ERROR_MESSAGE_SUFFIX;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_HAS_STRING;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_NOT_POSITIVE;
import static lotto.common.message.ErrorMessage.PURCHASE_AMOUNT_TOO_BIG;

public class PurchaseAmount {

    private final long purchaseAmount;

    public PurchaseAmount(String input) {
        double purchaseAmount = checkPriceOnlyNumber(input);
        checkPriceTooBig(purchaseAmount);
        checkPriceNotPositive(purchaseAmount);
        checkAmountIsMultipleOfLottoPrice(purchaseAmount);

        this.purchaseAmount = (long) purchaseAmount;
    }

    public long getPurchaseAmount() {
        return purchaseAmount;
    }

    private double checkPriceOnlyNumber(String input) {
        double price;

        try {
            price = Double.parseDouble(input);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SUFFIX.getMessage()
                    + PURCHASE_AMOUNT_HAS_STRING.getMessage());
        }

        return price;
    }

    private void checkPriceTooBig(double price) {
        if (Double.isInfinite(price) || price > MAX_PURCHASE_AMOUNT) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SUFFIX.getMessage()
                    + PURCHASE_AMOUNT_TOO_BIG.getMessage());
        }
    }

    private void checkPriceNotPositive(double price) {
        if (price <= 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SUFFIX.getMessage()
                    + PURCHASE_AMOUNT_NOT_POSITIVE.getMessage());
        }
    }

    private void checkAmountIsMultipleOfLottoPrice(double price) {
        if (price % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SUFFIX.getMessage()
                    + PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE.getMessage());
        }
    }
}
