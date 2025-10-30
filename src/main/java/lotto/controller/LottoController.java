package lotto.controller;

import lotto.model.PurchasedLottosDto;
import lotto.model.PurchaseAmount;
import lotto.model.service.LottoService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;
    private final LottoService lottoService;

    public LottoController(LottoView lottoView, LottoService lottoService) {
        this.lottoView = lottoView;
        this.lottoService = lottoService;
    }

    public void run() {
        String input = lottoView.requestPurchaseAmount();
        PurchaseAmount lottoPurchaseAmount = new PurchaseAmount(input);

        PurchasedLottosDto purchasedLottosDto = lottoService.buyLotto(lottoPurchaseAmount);
    }
}
