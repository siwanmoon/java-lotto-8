package lotto.controller;

import static lotto.common.message.ErrorMessage.BONUS_NUMBER_DUPLICATION;

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
        BonusNumber bonusNumber = requestBonusNumber(winningLotto);

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

    private BonusNumber requestBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                String input = lottoView.requestBonusNumber();
                BonusNumber bonusNumber = new BonusNumber(input);
                validateBonusDuplication(winningLotto, bonusNumber);

                return bonusNumber;
            } catch (IllegalArgumentException iae) {
                lottoView.printErrorMessage(iae.getMessage());
            }
        }
    }

    private void validateBonusDuplication(Lotto winningLotto,BonusNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber.getBonusNumber())) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION.getMessage());
        }
    }
}
