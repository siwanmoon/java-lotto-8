package lotto.model.service;

import lotto.model.firstclasscollection.LottoTicketsDTO;
import lotto.model.PurchaseAmount;

public interface LottoBuyingService {

    LottoTicketsDTO buyLotto(PurchaseAmount purchaseAmount);
}
