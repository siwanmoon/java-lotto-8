package lotto.controller;

import lotto.model.firstclasscollection.LottoTicketsDTO;
import lotto.model.PurchaseAmount;
import lotto.model.service.LottoBuyingService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;
    private final LottoBuyingService lottoBuyingService;

    public LottoController(LottoView lottoView, LottoBuyingService lottoBuyingService) {
        this.lottoView = lottoView;
        this.lottoBuyingService = lottoBuyingService;
    }

    public void run() {
        PurchaseAmount lottoPurchaseAmount = requestPurchaseAmount();
        LottoTicketsDTO lottoTicketsDTO = lottoBuyingService.buyLotto(lottoPurchaseAmount);
        lottoView.printPurchasedLottos(lottoTicketsDTO);

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
