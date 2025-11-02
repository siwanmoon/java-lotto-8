package lotto.model;

import java.util.Map;
import lotto.common.LottoRank;

public record WinningResultDTO(Map<LottoRank, Integer> statistics, double profitRate) {

    public static WinningResultDTO of(LottoResult lottoResult, double profitRate) {
        return new WinningResultDTO(lottoResult.getStatistics(), profitRate);
    }
}
