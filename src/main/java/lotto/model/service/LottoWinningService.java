package lotto.model.service;

import lotto.model.PurchaseAmount;
import lotto.model.WinningLotto;
import lotto.model.WinningResultDTO;
import lotto.model.firstclasscollection.LottoTickets;

public interface LottoWinningService {

    WinningResultDTO calculateWinningResult(LottoTickets userTickets,
                                            WinningLotto winningLotto,
                                            PurchaseAmount purchaseAmount);
}
