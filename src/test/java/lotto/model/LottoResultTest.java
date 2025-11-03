package lotto.model;

import java.util.Map;
import java.util.EnumMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void getStatistics가_통계_맵을_정확히_반환한다() {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        statistics.put(LottoRank.FIFTH, 1);
        statistics.put(LottoRank.FOURTH, 2);

        LottoResult lottoResult = new LottoResult(statistics);

        assertThat(lottoResult.getStatistics())
                .hasSize(2)
                .containsEntry(LottoRank.FIFTH, 1)
                .containsEntry(LottoRank.FOURTH, 2);
    }

    @Test
    void getTotalPrizeMoney가_총_상금을_정확히_계산한다() {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        statistics.put(LottoRank.FIFTH, 1); // 5,000 * 1
        statistics.put(LottoRank.FOURTH, 2); // 50,000 * 2
        statistics.put(LottoRank.FIRST, 1); // 2,000,000,000 * 1

        LottoResult lottoResult = new LottoResult(statistics);

        long expectedPrize = (5_000L * 1) + (50_000L * 2) + (2_000_000_000L * 1);
        assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(expectedPrize);
    }

    @Test
    void 통계_맵이_비어있을_때_총_상금은_0원이다() {
        Map<LottoRank, Integer> statistics = new EnumMap<>(LottoRank.class);
        LottoResult lottoResult = new LottoResult(statistics);

        assertThat(lottoResult.getTotalPrizeMoney()).isEqualTo(0L);
    }
}
