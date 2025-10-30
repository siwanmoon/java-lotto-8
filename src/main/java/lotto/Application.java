package lotto;

import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.LottoView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoView lottoView = new LottoView(inputView, outputView);
        LottoController lottoController = new LottoController(lottoView);

        lottoController.run();
    }
}
