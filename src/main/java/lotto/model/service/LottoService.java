package lotto.model.service;

import lotto.model.PurchasedLottosDto;
import lotto.model.PurchaseAmount;

public interface LottoService {

    PurchasedLottosDto buyLotto(PurchaseAmount purchaseAmount);
}
