package lotto.model;

import java.util.Map;
import java.util.EnumMap;
import lotto.common.LottoRank;

public class LottoResult {

    private final Map<LottoRank, Integer> statistics;

    public LottoResult(Map<LottoRank, Integer> statistics) {
        this.statistics = new EnumMap<>(statistics);
    }

    public Map<LottoRank, Integer> getStatistics() {
        return statistics;
    }

    public long getTotalPrizeMoney() {
        long total = 0;

        for (Map.Entry<LottoRank, Integer> entry : statistics.entrySet()) {
            LottoRank rank = entry.getKey();
            int count = entry.getValue();
            total += rank.getPrizeMoney() * count;
        }

        return total;
    }
}
