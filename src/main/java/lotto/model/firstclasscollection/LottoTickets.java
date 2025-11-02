package lotto.model.firstclasscollection;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.common.LottoRank;
import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.WinningLotto;

public class LottoTickets {

    private final List<Lotto> lottoTickets;

    public LottoTickets(List<Lotto> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public LottoResult calculateStatistics(WinningLotto winningLotto) {

        Map<LottoRank, Integer> resultCounts = new EnumMap<>(LottoRank.class);

        for (Lotto ticket : lottoTickets) {
            LottoRank rank = winningLotto.calculateRank(ticket);

            if (rank != null) {
                resultCounts.put(rank, resultCounts.getOrDefault(rank, 0) + 1);
            }
        }

        return new LottoResult(resultCounts);
    }
}
