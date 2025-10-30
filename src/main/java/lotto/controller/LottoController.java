package lotto.controller;

import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;

    public LottoController(LottoView lottoView) {
        this.lottoView = lottoView;
    }

    public void run() {
        double lottoPurchaseAmount = lottoView.requestPurchaseAmount();
    }
}
