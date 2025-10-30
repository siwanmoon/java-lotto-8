package lotto.controller;

import lotto.model.PurchaseAmount;
import lotto.model.service.LottoService;
import lotto.model.service.impl.LottoServiceImpl;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void run() {
        String input = lottoView.requestPurchaseAmount();
        PurchaseAmount lottoPurchaseAmount = new PurchaseAmount(input);
        LottoService lottoService = new LottoServiceImpl(lottoPurchaseAmount);
    }
}
