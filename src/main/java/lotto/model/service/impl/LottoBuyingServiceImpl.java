package lotto.model.service.impl;

import static lotto.common.Strategy.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.generator.LottoGenerator;
import lotto.model.PurchaseAmount;
import lotto.model.firstclasscollection.LottoTickets;
import lotto.model.service.LottoBuyingService;

public class LottoBuyingServiceImpl implements LottoBuyingService {

    private final LottoGenerator lottoGenerator;

    public LottoBuyingServiceImpl(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    @Override
    public LottoTickets buyLotto(PurchaseAmount purchaseAmount) {
        long lottoTicketsCount = countLottoTickets(purchaseAmount);
        return generateLottoTickets(lottoTicketsCount);
    }

    private long countLottoTickets(PurchaseAmount purchaseAmount) {
        long amount = purchaseAmount.getPurchaseAmount();
        return amount / LOTTO_PRICE;
    }

    private LottoTickets generateLottoTickets(long lottoTicketsCount) {
        List<Lotto> generatedTickets = Stream.generate(lottoGenerator::buyOneLotto)
                .limit(lottoTicketsCount)
                .collect(Collectors.toList());

        return new LottoTickets(generatedTickets);
    }
}
