package lotto.model.service.impl;

import lotto.model.LottoResult;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.model.dto.WinningResultDTO;
import lotto.model.firstclasscollection.LottoTickets;
import lotto.model.service.LottoWinningService;

public class LottoWinningServiceImpl implements LottoWinningService {

    @Override
    public WinningResultDTO calculateWinningResult(LottoTickets userTickets,
                                                   WinningLotto winningLotto,
                                                   PurchaseAmount purchaseAmount) {

        LottoResult lottoResult = userTickets.calculateStatistics(winningLotto);

        long totalPrize = lottoResult.getTotalPrizeMoney();
        long totalPurchase = purchaseAmount.getPurchaseAmount();
        double profitRate = 0;

        if (totalPurchase > 0) {
            profitRate = ((double) totalPrize / totalPurchase) * 100;
        }

        return WinningResultDTO.of(lottoResult, profitRate);
    }
}
