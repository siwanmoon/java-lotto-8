package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGenerator;
import lotto.model.service.LottoService;
import lotto.model.service.LottoServiceImpl;
import lotto.view.InputView;
import lotto.view.LottoView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoView lottoView = new LottoView(inputView, outputView);
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoService lottoService = new LottoServiceImpl(lottoGenerator);
        LottoController lottoController = new LottoController(lottoView, lottoService);

        lottoController.run();
    }
}
