package lotto.common.message;

import static lotto.common.constant.Validator.LOTTO_PRICE;

public enum ErrorMessage {

    ERROR_MESSAGE_SUFFIX("[ERROR] "),
    PURCHASE_AMOUNT_HAS_STRING("구입 금액에 문자가 입력되었습니다."),
    PURCHASE_AMOUNT_TOO_BIG("구입 금액이 너무 큽니다. 8,145,060,000원 이하의 값을 입력해야 합니다."),
    PURCHASE_AMOUNT_NOT_POSITIVE("구입 금액으로는 양수만 입력 가능합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE("잔돈이 남습니다. 로또 한장의 가격은 " + LOTTO_PRICE + "원 입니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
