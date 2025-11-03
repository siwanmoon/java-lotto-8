package lotto.controller;

import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.WinningLotto;
import lotto.model.dto.WinningResultDTO;
import lotto.model.firstclasscollection.LottoTickets;
import lotto.model.dto.LottoTicketsDTO;
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

        LottoTickets userTickets = buyLotto(lottoPurchaseAmount);

        Lotto winningLottoWithoutBonus = requestLottoWinningNumber();
        WinningLotto winningLotto = requestBonusNumber(winningLottoWithoutBonus);

        WinningResultDTO winningResultDTO = lottoWinningService.calculateWinningResult(
                userTickets,
                winningLotto,
                lottoPurchaseAmount);

        lottoView.printWinningResult(winningResultDTO);
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

    private WinningLotto requestBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String input = lottoView.requestBonusNumber();
                BonusNumber bonusNumber = new BonusNumber(input);
                return new WinningLotto(winningLotto, bonusNumber);
            } catch (IllegalArgumentException iae) {
                lottoView.printErrorMessage(iae.getMessage());
            }
        }
    }
}
