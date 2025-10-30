package lotto.view;

import lotto.util.InputValidator;

public class LottoView {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public LottoView(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public double requestPurchaseAmount() {
        outputView.requestPurchaseAmount();
        String input = inputView.getTrimmedInput();
        inputValidator.purchaseAmount(input);
        return Double.parseDouble(input);
    }
}
