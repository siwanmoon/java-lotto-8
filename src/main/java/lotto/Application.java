package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoGenerator;
import lotto.model.LottoGeneratorImpl;
import lotto.model.service.LottoBuyingService;
import lotto.model.service.LottoBuyingServiceImpl;
import lotto.view.InputView;
import lotto.view.LottoView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoView lottoView = new LottoView(inputView, outputView);
        LottoGenerator lottoGenerator = new LottoGeneratorImpl();
        LottoBuyingService lottoBuyingService = new LottoBuyingServiceImpl(lottoGenerator);
        LottoController lottoController = new LottoController(lottoView, lottoBuyingService);

        lottoController.run();
    }
}
