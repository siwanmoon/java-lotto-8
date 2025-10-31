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
        PurchaseAmount lottoPurchaseAmount = requestPurchaseAmount();

        PurchasedLottosDto purchasedLottosDto = lottoService.buyLotto(lottoPurchaseAmount);
        // docs: README에 클래스 설명 추가
        // test: 테스트 코드 추가
        // feat: 구매한 로또 출력 기능 추가
    }

    private PurchaseAmount requestPurchaseAmount() {
        PurchaseAmount lottoPurchaseAmount;

        while (true) {
            try {
                String input = lottoView.requestPurchaseAmount();
                return new PurchaseAmount(input);
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }
        }
    }
}
