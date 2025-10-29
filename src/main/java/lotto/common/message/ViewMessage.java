package lotto.common.message;

public enum ViewMessage {

    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
