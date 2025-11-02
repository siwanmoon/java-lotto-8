package lotto.model.service;

import lotto.model.PurchaseAmount;
import lotto.model.firstclasscollection.LottoTickets;

public interface LottoBuyingService {

    LottoTickets buyLotto(PurchaseAmount purchaseAmount);
}
