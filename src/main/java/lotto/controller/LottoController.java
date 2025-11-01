package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoDTO;
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
        LottoTicketsDTO lottoTicketsDTO = buyLotto(lottoPurchaseAmount);
        Lotto winningLotto = requestLottoWinningNumber();
    }

    private PurchaseAmount requestPurchaseAmount() {
        while (true) {
            try {
                String input = lottoView.requestPurchaseAmount();
                return new PurchaseAmount(input);
            } catch (IllegalArgumentException iae) {
                lottoView.printErrorMessage(iae.getMessage());
            }
        }
    }

    private LottoTicketsDTO buyLotto(PurchaseAmount lottoPurchaseAmount) {
        LottoTicketsDTO lottoTicketsDTO = lottoBuyingService.buyLotto(lottoPurchaseAmount);
        lottoView.printPurchasedLottos(lottoTicketsDTO);

        return lottoTicketsDTO;
    }

    private Lotto requestLottoWinningNumber() {
        while (true) {
            try {
                String input = lottoView.requestLottoWinningNumber();
                return Lotto.of(input);
            } catch (IllegalArgumentException iae) {
                lottoView.printErrorMessage(iae.getMessage());
            }
        }
    }
}
