package lotto.common.message;

import static lotto.common.Strategy.LOTTO_MAX_NUMBER;
import static lotto.common.Strategy.LOTTO_MIN_NUMBER;
import static lotto.common.Strategy.LOTTO_PRICE;
import static lotto.common.Strategy.LOTTO_SIZE;
import static lotto.common.Strategy.MAX_PURCHASE_AMOUNT;

public enum ErrorMessage {

    ERROR_MESSAGE_PREFIX("[ERROR] "),

    PURCHASE_AMOUNT_NOT_BLANK("구입 금액이 입력되지 않았습니다."),
    PURCHASE_AMOUNT_HAS_STRING("구입 금액에 문자가 입력되었습니다."),
    PURCHASE_AMOUNT_TOO_BIG("구입 금액이 너무 큽니다. " + MAX_PURCHASE_AMOUNT + "원 이하의 값을 입력해야 합니다."),
    PURCHASE_AMOUNT_NOT_POSITIVE("구입 금액으로는 양수만 입력 가능합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_LOTTO_PRICE("잔돈이 남습니다. 로또 한장의 가격은 " + LOTTO_PRICE + "원 입니다."),

    INVALID_LOTTO_SIZE("로또 번호는 " + LOTTO_SIZE + "개여야 합니다."),
    LOTTO_NUMBER_NOT_BLANK("로또 번호로 공백이 입력될 수 없습니다."),
    LOTTO_NUMBER_NOT_NUMERIC("로또 번호는 숫자여야 합니다."),
    LOTTO_NUMBER_DECIMAL("로또 번호는 소수일 수 없습니다."),
    LOTTO_NUMBER_TOO_BIG("로또 번호가 너무 큽니다."),
    LOTTO_NUMBER_DUPLICATE("로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호는 " + LOTTO_MIN_NUMBER + "에서 " + LOTTO_MAX_NUMBER + "사이여야 합니다."),

    BONUS_NUMBER_HAS_STRING("보너스 번호에 문자가 입력되었습니다."),
    BONUS_NUMBER_OVER_MAX_NUMBER("보너스 번호는 " + LOTTO_MAX_NUMBER + "이하여야 합니다."),
    BONUS_NUMBER_UNDER_MIN_NUMBER("보너스 번호는 " + LOTTO_MIN_NUMBER + "이상이여야 합니다."),
    BONUS_NUMBER_DECIMAL("보너스 번호는 소수일 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
