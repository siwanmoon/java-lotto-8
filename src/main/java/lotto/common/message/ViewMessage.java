package lotto.common.message;

public enum ViewMessage {

    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요"),
    PRINT_TICKETS_COUNT("개를 구매했습니다."),
    PRINT_LOTTO_NUMBER_PREFIX("["),
    PRINT_LOTTO_NUMBER_SUFFIX("]"),
    PRINT_LOTTO_NUMBER_SEPERATOR(", "),
    REQUEST_LOTTO_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
