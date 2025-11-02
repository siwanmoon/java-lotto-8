package lotto.model.service;

import lotto.model.LottoResult;
import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.model.firstclasscollection.LottoTickets;

public class LottoWinningServiceImpl implements LottoWinningService {

    @Override
    public LottoResult calculateStatistics(LottoTickets userTickets, WinningLotto winningLotto) {
        return userTickets.calculateStatistics(winningLotto);
    }

    @Override
    public double calculateProfitRate(LottoResult lottoResult, PurchaseAmount purchaseAmount) {
        long totalPrize = lottoResult.getTotalPrizeMoney();
        long totalPurchase = purchaseAmount.getPurchaseAmount();

        if (totalPurchase == 0) {
            return 0;
        }

        double rate = (double) totalPrize / totalPurchase;

        return rate * 100;
    }
}
