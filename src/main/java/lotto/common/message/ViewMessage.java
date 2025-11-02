package lotto.common.message;

public enum ViewMessage {

    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요"),
    PRINT_TICKETS_COUNT("개를 구매했습니다."),
    PRINT_LOTTO_NUMBER_PREFIX("["),
    PRINT_LOTTO_NUMBER_SUFFIX("]"),
    PRINT_LOTTO_NUMBER_SEPERATOR(", "),
    REQUEST_LOTTO_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_RESULT_STATISTICS("당첨 통계\n---"),
    STATISTICS_DELIMITER(" - "),
    TICKET_COUNT_UNIT("개"),
    PRINT_PROFIT_RATE_PREFIX("총 수익률은 "),
    PRINT_PROFIT_RATE_SUFFIX("%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
