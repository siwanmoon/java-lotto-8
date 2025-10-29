package lotto.controller;

import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;

    public LottoController(InputView inputView, OutputView outputView, InputValidator inputValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
    }

    public void run() {
        long lottoPurchaseAmount = requestPurchaseAmount();
    }

    private long requestPurchaseAmount() {
        outputView.requestPurchaseAmount();
        String input = inputView.getInput();
        return inputValidator.purchaseAmount(input);
    }
}
