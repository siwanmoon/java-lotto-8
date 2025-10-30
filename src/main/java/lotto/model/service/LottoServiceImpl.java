package lotto.model.service;

import static lotto.common.Strategy.LOTTO_PRICE;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.model.Lotto;
import lotto.model.PurchasedLottosDto;
import lotto.model.PurchaseAmount;
import lotto.model.firstclasscollection.LottoTickets;

public class LottoServiceImpl implements LottoService {

    private final LottoGenerator lottoGenerator;

    public LottoServiceImpl(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
    }

    @Override
    public PurchasedLottosDto buyLotto(PurchaseAmount purchaseAmount) {
        long lottoTicketsCount = countLottoTickets(purchaseAmount);
        LottoTickets lottoTickets = generateLottoTickets(lottoTicketsCount);
        return new PurchasedLottosDto(lottoTicketsCount, lottoTickets);
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
