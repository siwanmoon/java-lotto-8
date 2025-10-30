package lotto;

import lotto.controller.LottoController;
import lotto.util.InputValidator;
import lotto.view.InputView;
import lotto.view.LottoView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        InputValidator inputValidator = new InputValidator();
        LottoView lottoView = new LottoView(inputView, outputView, inputValidator);
        LottoController lottoController = new LottoController(lottoView);

        lottoController.run();
    }
}
