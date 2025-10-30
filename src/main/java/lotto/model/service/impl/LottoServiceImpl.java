package lotto.model.service.impl;

import lotto.model.PurchaseAmount;
import lotto.model.service.LottoService;

public class LottoServiceImpl implements LottoService {

    private final PurchaseAmount lottoPurchaseAmount;

    public LottoServiceImpl(PurchaseAmount lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    @Override
    public long getLottoTicketCount() {

    }
}
