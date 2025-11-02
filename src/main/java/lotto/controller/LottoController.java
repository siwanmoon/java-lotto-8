package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.firstclasscollection.LottoTickets;
import lotto.model.firstclasscollection.LottoTicketsDTO;
import lotto.model.PurchaseAmount;
import lotto.model.service.LottoBuyingService;
import lotto.model.service.LottoWinningService;
import lotto.view.LottoView;

public class LottoController {

    private final LottoView lottoView;
    private final LottoBuyingService lottoBuyingService;
    private final LottoWinningService lottoWinningService;

    public LottoController(LottoView lottoView,
                           LottoBuyingService lottoBuyingService,
                           LottoWinningService lottoWinningService) {
        this.lottoView = lottoView;
        this.lottoBuyingService = lottoBuyingService;
        this.lottoWinningService = lottoWinningService;
    }

    public void run() {
        PurchaseAmount lottoPurchaseAmount = requestPurchaseAmount();
        LottoTickets lottoTickets = buyLotto(lottoPurchaseAmount);
        Lotto winningLotto = requestLottoWinningNumber();
        BonusNumber bonusNumber = requestBonusNumber();

        // feat: 로또 당첨 기능 추가해야함
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

    private LottoTickets buyLotto(PurchaseAmount lottoPurchaseAmount) {
        LottoTickets lottoTickets = lottoBuyingService.buyLotto(lottoPurchaseAmount);
        LottoTicketsDTO lottoTicketsDTO = LottoTicketsDTO.from(lottoTickets);
        lottoView.printPurchasedLottos(lottoTicketsDTO);

        return lottoTickets;
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

    private BonusNumber requestBonusNumber() {
        while (true) {
            try {
                String input = lottoView.requestBonusNumber();
                return new BonusNumber(input);
            } catch (IllegalArgumentException iae) {
                lottoView.printErrorMessage(iae.getMessage());
            }
        }
    }
}
